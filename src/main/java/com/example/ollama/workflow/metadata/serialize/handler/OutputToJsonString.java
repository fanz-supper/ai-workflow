package com.example.ollama.workflow.metadata.serialize.handler;

import com.alibaba.fastjson2.JSON;
import com.example.ollama.workflow.metadata.Output;
import com.example.ollama.workflow.metadata.SerializeHandler;

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
