package com.example.ollama.workflow.llm;

import com.example.ollama.workflow.metadata.base.ModelInput;

/**
 * @title: LLMFactory
 * @description:
 * @author: zhangfan
 */
public interface LLMFactory {

    LLMEu get(ModelInput input);

}

