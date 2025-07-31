package com.ai.workflow.metadata.serialize.handler;

import com.ai.workflow.metadata.Output;
import com.ai.workflow.metadata.SerializeHandler;
import com.alibaba.fastjson2.JSON;

/**
 * @title: OutputToJsonString
 * @description:
 * @author: zhangfan
 */
public class OutputToJsonString implements SerializeHandler<Output<?>, String> {

    @Override
    public String handle(Output<?> output) {
        return JSON.toJSONString(output);
    }

}
