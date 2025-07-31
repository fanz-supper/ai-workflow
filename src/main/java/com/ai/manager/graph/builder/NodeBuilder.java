package com.ai.manager.graph.builder;

import com.ai.manager.graph.Graph;
import com.ai.workflow.flow.NodeProcessor;
import com.ai.workflow.metadata.Input;

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
