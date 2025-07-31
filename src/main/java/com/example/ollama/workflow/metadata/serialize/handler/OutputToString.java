package com.example.ollama.workflow.metadata.serialize.handler;

import com.example.ollama.workflow.metadata.Output;
import com.example.ollama.workflow.metadata.SerializeHandler;

/**
 * @title: OutputToString
 * @description:
 * @author: zhangfan
 */
public class OutputToString implements SerializeHandler<Output<?>, String> {

    @Override
    public String handle(Output<?> output) {

        if (output != null && output.content() != null) {

            if (output.content() instanceof String str) {
                return str;
            }
            return output.content().toString();
        }

        return "";
    }
}
