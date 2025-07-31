package com.ai.workflow.metadata.serialize.handler;

import com.ai.workflow.metadata.Input;
import com.ai.workflow.metadata.SerializeHandler;

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
