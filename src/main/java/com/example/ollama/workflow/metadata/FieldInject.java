package com.example.ollama.workflow.metadata;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @title: Field
 * @description:
 * @author: zhangfan
 * @data: 2025年04月17日 21:46
 */
public interface FieldInject<T extends Input, V> {

    BiConsumer<T, V> setV();

    Supplier<Object> source();

}
