package com.ai.manager.graph;

import com.ai.manager.graph.builder.NodeBuilderFactory;
import com.ai.workflow.flow.NodeProcessor;
import com.ai.workflow.metadata.Input;
import com.alibaba.fastjson2.JSON;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @title: Parser
 * @description:
 * @author: zhangfan
 */
@AllArgsConstructor
public class Parser {

    private NodeBuilderFactory nodeBuilderFactory;
    private ProcessorAssembler processorAssembler;

    public List<NodeProcessor<? extends Input>> parse(String json) {

        Graph graph = JSON.parseObject(json, Graph.class);

        Map<String, Graph.Node> nodeMap = graph.getNodes().stream()
                .collect(Collectors.toMap(
                        Graph.Node::getId,
                        Function.identity()));

        for (Graph.Edge edge : graph.getEdges()) {

            Graph.Node source = nodeMap.get(edge.getSource());
            Graph.Node target = nodeMap.get(edge.getTarget());

            source.addNext(target);
            target.addPre(source);
        }

        List<Graph.Node> headers = header(graph.getNodes());
        Map<String, NodeProcessor<? extends Input>> nodeProcessorBuiltMap = new HashMap<>();

        eachNext(headers, null, nodeProcessorBuiltMap);

        List<NodeProcessor<? extends Input>> nodeProcessorHeaders = nodeProcessorBuiltMap.values().stream()
                .filter(np -> np.prevs() == null)
                .toList();

        return processorAssembler.assemble(nodeProcessorHeaders);
    }


    private void eachNext(List<Graph.Node> nexts, NodeProcessor<? extends Input> preNodeProcessor, Map<String,
            NodeProcessor<? extends Input>> nodeProcessorBuiltMap) {

        if (nexts == null) {
            return;
        }

        for (Graph.Node next : nexts) {

            final Graph.Node currentNode = next;

            NodeProcessor<? extends Input> nodeProcessor = nodeProcessorBuiltMap.get(currentNode.getId());
            if (nodeProcessor == null) {

                nodeProcessor = nodeBuilderFactory.getBuilder(
                        currentNode.serviceType()).build(currentNode, nodeProcessorBuiltMap);

                nodeProcessorBuiltMap.put(currentNode.getId(), nodeProcessor);
                eachNext(next.getNexts(), nodeProcessor, nodeProcessorBuiltMap);
            }
            connectProcessor(preNodeProcessor, nodeProcessor);
        }
    }

    private List<Graph.Node> header(List<Graph.Node> nodes) {

        return nodes.stream()
                .filter(node -> node.getPres() == null)
                .toList();
    }

    private void connectProcessor(NodeProcessor np1, NodeProcessor np2) {

        if (np1 == null || np2 == null) {
            return;
        }

        np1.addNext(np2);
        np2.addPre(np1);
    }


}
