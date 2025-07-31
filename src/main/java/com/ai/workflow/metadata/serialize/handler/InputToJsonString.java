package com.ai.workflow.metadata.serialize.handler;

import com.ai.workflow.metadata.Input;
import com.ai.workflow.metadata.SerializeHandler;
import com.alibaba.fastjson2.JSON;

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
