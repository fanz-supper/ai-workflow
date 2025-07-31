package com.ai.workflow.llm;

import com.ai.workflow.metadata.base.ModelInput;

/**
 * @title: LLMFactory
 * @description:
 * @author: zhangfan
 */
public interface LLMFactory {

    LLMEu get(ModelInput input);

}

