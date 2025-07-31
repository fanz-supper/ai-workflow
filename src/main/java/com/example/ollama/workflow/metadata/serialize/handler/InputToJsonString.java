package com.example.ollama.workflow.metadata.serialize.handler;

import com.alibaba.fastjson2.JSON;
import com.example.ollama.workflow.metadata.Input;
import com.example.ollama.workflow.metadata.SerializeHandler;

/**
 * @title: ToJsonString
 * @description:
 * @author: zhangfan
 */
public class InputToJsonString<T extends Input> implements SerializeHandler<T, String> {

    @Override
    public String handle(T t) {
        return JSON.toJSONString(t);
    }
}
