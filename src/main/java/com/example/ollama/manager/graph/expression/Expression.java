package com.example.ollama.manager.graph.expression;

import com.example.ollama.workflow.flow.NodeProcessor;
import com.example.ollama.workflow.metadata.FieldInject;
import com.example.ollama.workflow.metadata.Input;

import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @title: Expression
 * @description:
 * @author: zhangfan
 * @data: 2025年05月11日 15:02
 */
public interface Expression {

    <T extends Input, V> FieldInject<T, V> convert(Map<String, Object> expressionMap, Map<String, NodeProcessor> buildMap,
                                                   BiConsumer<T, V> setV);
}
