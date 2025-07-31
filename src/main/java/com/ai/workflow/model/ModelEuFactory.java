package com.ai.workflow.model;

import com.ai.workflow.EditorEu;
import com.ai.workflow.ModelEu;
import com.ai.workflow.PromptEu;
import com.ai.workflow.data.converter.DataConverterFactory;
import com.ai.workflow.llm.LLMFactory;
import com.ai.workflow.metadata.base.ModelInput;

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
