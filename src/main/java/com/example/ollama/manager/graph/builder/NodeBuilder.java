package com.example.ollama.manager.graph.builder;

import com.example.ollama.manager.graph.Graph;
import com.example.ollama.workflow.flow.NodeProcessor;
import com.example.ollama.workflow.metadata.Input;

import java.util.Map;

/**
 * @title: NodeBuilder
 * @description:
 * @author: zhangfan
 * @data: 2025年05月09日 16:07
 */
public interface NodeBuilder<NP extends NodeProcessor<? extends Input>> {

    NP build(Graph.Node node, Map<String, NodeProcessor> buildMap);
}
