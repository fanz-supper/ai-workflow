package com.example.ollama.workflow.metadata;

/**
 * @title: Attribute
 * @description:
 * @author: zhangfan
 * @data: 2025年05月19日 15:49
 */
public interface Attribute<V> {

    String getK();

    String getNodeK();

    V getV();
}
