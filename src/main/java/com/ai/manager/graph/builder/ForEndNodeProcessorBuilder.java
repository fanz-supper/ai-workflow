package com.ai.manager.graph.builder;


import com.ai.manager.graph.Graph;
import com.ai.manager.graph.attr.NodeIdAttr;
import com.ai.manager.graph.attr.NodeNameAttr;
import com.ai.manager.graph.attr.NodeServiceTypeAttr;
import com.ai.workflow.flow.ForNodeProcessor;
import com.ai.workflow.flow.NodeProcessor;
import com.ai.workflow.flow.impl.ForNodeProcessorImpl;
import com.ai.workflow.metadata.serialize.handler.InputToEmptyString;
import com.ai.workflow.metadata.serialize.handler.OutputToJsonString;

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
