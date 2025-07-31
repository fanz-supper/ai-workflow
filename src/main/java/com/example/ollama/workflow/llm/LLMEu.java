package com.example.ollama.workflow.llm;

import com.example.ollama.workflow.metadata.base.StringOutput;

/**
 * @title: LLMProcessor
 * @description:
 * @author: zhangfan
 * @data: 2025年03月13日 21:52
 */
public interface LLMEu {

    StringOutput call(String msg);
}
