package com.ai.manager.graph.builder;

import com.ai.manager.graph.Graph;
import com.ai.manager.graph.attr.NodeIdAttr;
import com.ai.manager.graph.attr.NodeNameAttr;
import com.ai.manager.graph.attr.NodeServiceTypeAttr;
import com.ai.workflow.flow.ForNodeProcessor;
import com.ai.workflow.flow.NodeProcessor;
import com.ai.workflow.flow.impl.ForNodeProcessorImpl;
import com.ai.workflow.metadata.serialize.handler.InputToEmptyString;
import com.ai.workflow.metadata.serialize.handler.OutputToEmptyString;

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
