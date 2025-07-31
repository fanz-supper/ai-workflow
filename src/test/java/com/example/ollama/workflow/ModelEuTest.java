package com.example.ollama.workflow;

import com.example.ollama.workflow.editor.EditorEuStringImpl;
import com.example.ollama.workflow.llm.LLMEu;
import com.example.ollama.workflow.metadata.Output;
import com.example.ollama.workflow.metadata.base.ModelInput;
import com.example.ollama.workflow.metadata.base.StringOutput;
import com.example.ollama.workflow.model.ModelEuImpl;
import com.example.ollama.workflow.prompt.PromptEuImpl;
import com.example.ollama.workflow.repository.PromptTemplateFactory;
import org.junit.jupiter.api.Test;

/**
 * @title: ModelEuNodeTest
 * @description:
 * @author: zhangfan
 */
public class ModelEuTest {

    @Test
    public void execute() {

        ModelInput modelInput = new ModelInput();
        modelInput.setMsg("模型input");

        PromptTemplateFactory promptTemplateFactory = name -> "prompt template is empty";
        PromptEuImpl promptEu = new PromptEuImpl(promptTemplateFactory);
        EditorEuStringImpl editorEuString = new EditorEuStringImpl();
        DataConvertEu dataConvertEu = output -> output;
        LLMEu llmEu = msg -> new StringOutput("这就算是远程调用了：" + msg);

        ModelEuImpl modelEu = new ModelEuImpl(modelInput, promptEu, editorEuString, dataConvertEu, llmEu);

        Output call = modelEu.call();

        System.out.println(call.content());

    }
}
