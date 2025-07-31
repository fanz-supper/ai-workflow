package com.example.ollama.workflow.metadata.serialize.handler;

import com.example.ollama.workflow.metadata.Output;
import com.example.ollama.workflow.metadata.SerializeHandler;

/**
 * @title: OutputToEmpty
 * @description:
 * @author: zhangfan
 */
public class OutputToEmptyString implements SerializeHandler<Output<?>, String> {

    @Override
    public String handle(Output<?> output) {
        return "";
    }
}
