package com.example.ollama.manager.graph.builder;


import com.example.ollama.manager.graph.Graph;
import com.example.ollama.manager.graph.attr.NodeIdAttr;
import com.example.ollama.manager.graph.attr.NodeNameAttr;
import com.example.ollama.manager.graph.attr.NodeServiceTypeAttr;
import com.example.ollama.workflow.flow.ForNodeProcessor;
import com.example.ollama.workflow.flow.NodeProcessor;
import com.example.ollama.workflow.flow.impl.ForNodeProcessorImpl;
import com.example.ollama.workflow.metadata.serialize.handler.InputToEmptyString;
import com.example.ollama.workflow.metadata.serialize.handler.OutputToJsonString;

import java.util.Map;

/**
 * @title: ForEndNodeProcessorBuilder
 * @description:
 * @author: zhangfan
 */
public class ForEndNodeProcessorBuilder implements NodeBuilder<ForNodeProcessor.EndNodeProcessor> {

    @Override
    public ForNodeProcessor.EndNodeProcessor build(Graph.Node node, Map<String, NodeProcessor> buildMap) {

        ForNodeProcessorImpl.EndNodeProcessor endNodeProcessor = new ForNodeProcessorImpl.EndNodeProcessor();
        endNodeProcessor.setInputSerializeHandler(new InputToEmptyString());
        endNodeProcessor.setOutputSerializeHandler(new OutputToJsonString());

        NodeIdAttr nodeIdAttr = new NodeIdAttr(node.getId());
        NodeNameAttr nodeNameAttr = new NodeNameAttr(String.valueOf(node.getData().getParams().get(NodeNameAttr.NODE_KEY)));
        NodeServiceTypeAttr nodeServiceTypeAttr = new NodeServiceTypeAttr(String.valueOf(node.getData().getOptions().getServiceType()));

        endNodeProcessor
                .putAttr(nodeIdAttr)
                .putAttr(nodeNameAttr)
                .putAttr(nodeServiceTypeAttr);

        return endNodeProcessor;
    }

}
