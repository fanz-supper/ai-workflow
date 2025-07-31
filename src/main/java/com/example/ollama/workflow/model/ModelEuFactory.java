package com.example.ollama.workflow.model;

import com.example.ollama.workflow.EditorEu;
import com.example.ollama.workflow.ModelEu;
import com.example.ollama.workflow.PromptEu;
import com.example.ollama.workflow.data.converter.DataConverterFactory;
import com.example.ollama.workflow.llm.LLMFactory;
import com.example.ollama.workflow.metadata.base.ModelInput;

/**
 * @title: ModelEuFactory
 * @description:
 * @author: zhangfan
 */
public interface ModelEuFactory {

    PromptEu promptEu();

    EditorEu editorEu();

    DataConverterFactory dataConverterFactory();

    LLMFactory llmFactory();

    ModelEu get(ModelInput modelInput);
}
