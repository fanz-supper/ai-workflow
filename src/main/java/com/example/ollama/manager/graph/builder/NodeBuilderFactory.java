package com.example.ollama.manager.graph.builder;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @title: NodeBuilderFactory
 * @description:
 * @author: zhangfan
 */
@Getter
@Setter
public class NodeBuilderFactory {

    private Map<String, NodeBuilder> builderMap = new HashMap<>();


    public NodeBuilderFactory register(String type, NodeBuilder nodeBuilder) {

        builderMap.put(type, nodeBuilder);
        return this;
    }

    public NodeBuilder getBuilder(String serviceType) {
        return builderMap.get(serviceType);
    }
}
