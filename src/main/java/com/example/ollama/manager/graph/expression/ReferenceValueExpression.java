package com.example.ollama.manager.graph.expression;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONPath;
import com.example.ollama.workflow.flow.NodeProcessor;
import com.example.ollama.workflow.metadata.FieldInject;
import com.example.ollama.workflow.metadata.Input;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @title: ReferenceValueExpression
 * @description:
 * @author: zhangfan
 */
public class ReferenceValueExpression implements Expression {

    @Override
    public <T extends Input, V> FieldInject<T, V> convert(Map<String, Object> expressionMap, Map<String, NodeProcessor> buildMap,
                                                          BiConsumer<T, V> setV) {

        String nodeId = String.valueOf(expressionMap.get("nodeId"));
        String path = String.valueOf(expressionMap.get("outputJsonPath"));

        if (buildMap.containsKey(nodeId)) {

            NodeProcessor sourceNodeProcessor = buildMap.get(nodeId);

            return new FieldInject() {
                @Override
                public BiConsumer<T, V> setV() {
                    return setV;
                }

                @Override
                public Supplier<Object> source() {
                    return () -> {
                        JSONObject jsonOutput = (JSONObject) sourceNodeProcessor.output().content();
                        return jsonOutput.eval(JSONPath.of(path));
                    };
                }
            };
        }

        throw new IllegalArgumentException("expression convert error :" + JSON.toJSONString(expressionMap));
    }


}
