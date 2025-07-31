package com.ai.workflow;

import com.ai.workflow.data.converter.DataConverterFactory;
import com.ai.workflow.editor.EditorEuStringImpl;
import com.ai.workflow.flow.NodeProcessor;
import com.ai.workflow.flow.impl.DiagramProcessorImpl;
import com.ai.workflow.flow.impl.ForNodeProcessorImpl;
import com.ai.workflow.flow.impl.IfNodeProcessorImpl;
import com.ai.workflow.flow.impl.ModelNodeProcessor;
import com.ai.workflow.llm.LLMEu;
import com.ai.workflow.llm.LLMFactory;
import com.ai.workflow.metadata.FieldInject;
import com.ai.workflow.metadata.Input;
import com.ai.workflow.metadata.TrueCondition;
import com.ai.workflow.metadata.base.ListOutput;
import com.ai.workflow.metadata.base.ModelInput;
import com.ai.workflow.metadata.base.StringOutput;
import com.ai.workflow.model.ModelEuFactoryImpl;
import com.ai.workflow.prompt.PromptEuImpl;
import com.ai.workflow.repository.PromptTemplateFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @title: DiagramProcessorTest
 * @description:
 * @author: zhangfan
 */
public class DiagramProcessorTest {

    private static PromptEu promptEu;
    private static EditorEu editorEu;
    private static DataConverterFactory dataConverterFactory;
    private static LLMFactory llmFactory;

    @BeforeAll
    public static void init() {
        PromptTemplateFactory promptTemplateFactory = name -> "prompt template is empty";
        promptEu = new PromptEuImpl(promptTemplateFactory);
        editorEu = new EditorEuStringImpl();

        dataConverterFactory = input -> (DataConvertEu) output -> output;
        llmFactory = input -> (LLMEu) msg -> new StringOutput("这就算是远程调用了：" + msg);
    }

    @Test
    public void process() {

        NodeProcessor header = m1();
        header.addNext(m2());

        DiagramProcessorImpl diagramProcessor = new DiagramProcessorImpl(List.of(header));
        diagramProcessor.process();
    }

    @Test
    public void ifProcess() {

        ModelNodeProcessor header = m1();
        ModelNodeProcessor m2 = m2();
        ModelNodeProcessor m3 = m3();
        ModelNodeProcessor m4 = m4();

        IfNodeProcessorImpl ifProcessor = new IfNodeProcessorImpl(new TrueCondition() {
            @Override
            public boolean isTrue() {
                return false;
            }

            @Override
            public void eu() {

            }

            @Override
            public void execute() {

            }
        }, m3, m4);

        header.addNext(m2);
        m2.addNext(ifProcessor);

        DiagramProcessorImpl diagramProcessor = new DiagramProcessorImpl(List.of(header));
        diagramProcessor.process();

    }


    @Test
    public void forProcess() {

        ForNodeProcessorImpl forNodeProcessor = new ForNodeProcessorImpl();
        ForNodeProcessorImpl.StartNodeProcessor startNodeProcessor = new ForNodeProcessorImpl.StartNodeProcessor() {
            @Override
            public void process() {
                ListOutput<String> listOutput = new ListOutput<>(List.of("1", "2", "3"));
                setOutput(listOutput);
            }
        };
        forNodeProcessor.setForStartNode(startNodeProcessor);
        forNodeProcessor.setNodeProcessors(List.of(m2(), m3()));

        startNodeProcessor.process();
        forNodeProcessor.process();

    }


    private ModelNodeProcessor m1() {

        ModelInput modelInput = new ModelInput();
        modelInput.setMsg("GTP3.5");

        return new ModelNodeProcessor(modelInput, new ModelEuFactoryImpl(promptEu, editorEu, dataConverterFactory, llmFactory));
    }

    private ModelNodeProcessor m2() {

        ModelInput modelInput = new ModelInput();
        modelInput.setMsg("GTP4.0");
        modelInput.setFieldConfigs(List.of(new FieldInject() {

            @Override
            public BiConsumer<Input, Object> setV() {
                return (input, o) -> ((ModelInput) input).setMsg(o.toString());
            }

            @Override
            public Supplier<Object> source() {
                return () -> new ListOutput<>(List.of("1", "2", "3"));
            }
        }));

        return new ModelNodeProcessor(modelInput, new ModelEuFactoryImpl(promptEu, editorEu, dataConverterFactory, llmFactory));
    }

    private ModelNodeProcessor m3() {

        ModelInput modelInput = new ModelInput();
        modelInput.setMsg("if true");

        return new ModelNodeProcessor(modelInput, new ModelEuFactoryImpl(promptEu, editorEu, dataConverterFactory, llmFactory));
    }

    private ModelNodeProcessor m4() {

        ModelInput modelInput = new ModelInput();
        modelInput.setMsg("true next");

        return new ModelNodeProcessor(modelInput, new ModelEuFactoryImpl(promptEu, editorEu, dataConverterFactory, llmFactory));
    }

}
