package com.example.ollama.workflow;

import com.example.ollama.workflow.llm.LLMEu;
import com.example.ollama.workflow.metadata.Output;
import com.example.ollama.workflow.metadata.base.ModelInput;

/**
 * @title: ModelEu
 * @description:
 * @author: zhangfan
 * @data: 2025年03月13日 20:11
 */
public interface ModelEu<U extends Output<?>> {

    PromptEu promptEu();

    ModelInput input();

    DataConvertEu dataConvertEu();

    LLMEu llmEu();

    EditorEu editorEu();

    U output();

    U call();
}
