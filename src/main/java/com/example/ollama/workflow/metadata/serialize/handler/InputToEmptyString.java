package com.example.ollama.workflow.metadata.serialize.handler;

import com.example.ollama.workflow.metadata.Input;
import com.example.ollama.workflow.metadata.SerializeHandler;

/**
 * @title: InputToEmpty
 * @description:
 * @author: zhangfan
 */
public class InputToEmptyString implements SerializeHandler<Input, String> {

    @Override
    public String handle(Input input) {
        return "";
    }
}
