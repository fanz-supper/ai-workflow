package com.ai.workflow.metadata.serialize.handler;

import com.ai.workflow.metadata.Output;
import com.ai.workflow.metadata.SerializeHandler;

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
