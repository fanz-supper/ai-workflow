package com.example.ollama.manager.graph.builder;

import com.example.ollama.manager.graph.Graph;
import com.example.ollama.manager.graph.attr.NodeIdAttr;
import com.example.ollama.manager.graph.attr.NodeNameAttr;
import com.example.ollama.manager.graph.attr.NodeServiceTypeAttr;
import com.example.ollama.workflow.flow.ForNodeProcessor;
import com.example.ollama.workflow.flow.NodeProcessor;
import com.example.ollama.workflow.flow.impl.ForNodeProcessorImpl;
import com.example.ollama.workflow.metadata.serialize.handler.InputToEmptyString;
import com.example.ollama.workflow.metadata.serialize.handler.OutputToEmptyString;

import java.util.Map;

/**
 * @title: ForStartNodeProcessorBuilder
 * @description:
 * @author: zhangfan
 */
public class ForStartNodeProcessorBuilder implements NodeBuilder<ForNodeProcessor.StartNodeProcessor> {
    @Override
    public ForNodeProcessor.StartNodeProcessor build(Graph.Node node, Map<String, NodeProcessor> buildMap) {

        ForNodeProcessorImpl.StartNodeProcessor startNodeProcessor = new ForNodeProcessorImpl.StartNodeProcessor();
        startNodeProcessor.setInputSerializeHandler(new InputToEmptyString());
        startNodeProcessor.setOutputSerializeHandler(new OutputToEmptyString());

        NodeIdAttr nodeIdAttr = new NodeIdAttr(node.getId());
        NodeNameAttr nodeNameAttr = new NodeNameAttr(String.valueOf(node.getData().getParams().get(NodeNameAttr.NODE_KEY)));
        NodeServiceTypeAttr nodeServiceTypeAttr = new NodeServiceTypeAttr(String.valueOf(node.getData().getOptions().getServiceType()));

        startNodeProcessor
                .putAttr(nodeIdAttr)
                .putAttr(nodeNameAttr)
                .putAttr(nodeServiceTypeAttr);

        return startNodeProcessor;
    }
}
