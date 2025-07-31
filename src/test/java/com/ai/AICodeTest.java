package com.ai;

import com.ai.workflow.flow.NodeProcessor;
import com.ai.workflow.flow.impl.DiagramProcessorImpl;
import com.ai.workflow.flow.impl.ForNodeProcessorImpl;
import com.ai.workflow.flow.impl.JavaFileWriteProcessor;
import com.ai.workflow.flow.impl.ModelNodeProcessor;
import com.ai.workflow.metadata.FieldInject;
import com.ai.workflow.metadata.Input;
import com.ai.workflow.metadata.base.JavaFileInput;
import com.ai.workflow.metadata.base.ModelInput;
import com.ai.workflow.model.ModelEuFactory;
import com.ai.workflow.repository.PromptTemplateFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @title: AICodeTest
 * @description:
 * @author: zhangfan
 */
@SpringBootTest
public class AICodeTest {

    @Autowired
    private ModelEuFactory modelEuFactory;
    @MockitoBean
    private PromptTemplateFactory promptTemplateFactory;

    @BeforeEach
    public void mockBeanTest() {

        when(promptTemplateFactory.getByKey(anyString()))
                .thenAnswer((Answer<String>) invocation -> TemplateStatic.tMap.get(invocation.getArguments()[0]));
    }

    @Test
    public void generateCode() {

        ModelNodeProcessor header = new ModelNodeProcessor(new ModelInput(TemplateStatic.des, "PartialModules", "DomainListYaml"), modelEuFactory);

        ForNodeProcessorImpl domainInfoItemFor = new ForNodeProcessorImpl();
        connectNext(header, domainInfoItemFor);

        ModelNodeProcessor domainInfoNode = new ModelNodeProcessor(new ModelInput("", "DomainInfo",
                "ETLYaml", List.of(new FieldInject() {
            @Override
            public BiConsumer<Input, Object> setV() {
                return (input, o) -> ((ModelInput) input).setMsg((String) o);
            }

            @Override
            public Supplier<Object> source() {
                return () -> header.output();
            }
        })), modelEuFactory);
        domainInfoItemFor.setNodeProcessors(List.of(domainInfoNode));

        ForNodeProcessorImpl patternItemFor = new ForNodeProcessorImpl();
        connectNext(domainInfoItemFor, patternItemFor);

        ModelNodeProcessor serviceNode = new ModelNodeProcessor(new ModelInput("", "ServiceImpl", "JavaYaml",
                List.of(new FieldInject() {
                    @Override
                    public BiConsumer<Input, Object> setV() {
                        return (input, o) -> ((ModelInput) input).setMsg(o.toString());
                    }

                    @Override
                    public Supplier<Object> source() {
                        return () -> domainInfoItemFor.output();
                    }
                })), modelEuFactory);
        ModelNodeProcessor controllerNode = new ModelNodeProcessor(new ModelInput("", "Controller", "JavaYaml",
                List.of(new FieldInject() {
                    @Override
                    public BiConsumer<Input, Object> setV() {
                        return (input, o) -> ((ModelInput) input).setMsg(o.toString());
                    }

                    @Override
                    public Supplier<Object> source() {
                        return () -> domainInfoItemFor.output();
                    }
                })), modelEuFactory);
        patternItemFor.setNodeProcessors(List.of(serviceNode, controllerNode));

        ForNodeProcessorImpl javaFileItemFor = new ForNodeProcessorImpl();
        connectNext(patternItemFor, javaFileItemFor);

        JavaFileWriteProcessor javaFileNode = new JavaFileWriteProcessor(new JavaFileInput("/Users/zhangfan/logs/aig",
                List.of(new FieldInject() {
                    @Override
                    public BiConsumer<Input, Object> setV() {
                        return (input, o) -> ((JavaFileInput) input).setContent(o.toString());
                    }

                    @Override
                    public Supplier<Object> source() {
                        return () -> patternItemFor.output();
                    }
                })));
//        SystemOutPrintNodeProcessor printNode = new SystemOutPrintNodeProcessor(new StringInput("",
//                List.of(new FieldInject() {
//                    @Override
//                    public BiConsumer<Input, Object> setV() {
//                        return (input, o) -> ((StringInput) input).setContent(o.toString());
//                    }
//
//                    @Override
//                    public Supplier<Object> source() {
//                        return () -> patternItemFor.output();
//                    }
//                })));
        javaFileItemFor.setNodeProcessors(List.of(javaFileNode));

        DiagramProcessorImpl diagramProcessor = new DiagramProcessorImpl(List.of(header));
        diagramProcessor.process();
    }

    private void connectNext(NodeProcessor node, NodeProcessor next) {
        node.addNext(next);
        next.addNext(node);
    }
}
