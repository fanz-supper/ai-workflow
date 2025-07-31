package com.example.ollama.workflow.flow.impl;

import com.example.ollama.workflow.exception.IsTureException;
import com.example.ollama.workflow.exception.NotNullException;
import com.example.ollama.workflow.flow.ForNodeProcessor;
import com.example.ollama.workflow.flow.NodeProcessor;
import com.example.ollama.workflow.metadata.Input;
import com.example.ollama.workflow.metadata.Output;
import com.example.ollama.workflow.metadata.base.EmptyInput;
import com.example.ollama.workflow.metadata.base.ListOutput;
import com.example.ollama.workflow.metadata.base.StringOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: ForProcessorImpl
 * @description:
 * @author: zhangfan
 */
public class ForNodeProcessorImpl extends AbstractNodeProcessor<EmptyInput> implements ForNodeProcessor<EmptyInput> {

    private ForNodeProcessor.StartNodeProcessor forStartNode;
    private ForNodeProcessor.EndNodeProcessor forEndNode;
    private List<NodeProcessor<? extends Input>> nodeProcessors;

    public ForNodeProcessorImpl() {
    }

    public ForNodeProcessorImpl(ForNodeProcessor.StartNodeProcessor forStartNode, ForNodeProcessor.EndNodeProcessor forEndNode,
                                List<NodeProcessor<? extends Input>> nodeProcessors) {
        this.forStartNode = forStartNode;
        this.forEndNode = forEndNode;
        this.nodeProcessors = nodeProcessors;
    }

    @Override
    public void doProcess() {

        if (nodeProcessors == null || nodeProcessors.size() < 1) {
            return;
        }

        Object output = prevs.get(0).output();
        NotNullException.check(output, "forStartNode output is null");
        IsTureException.check(output instanceof ListOutput, "forStartNode pre output is not list");

        ListOutput listOutput = (ListOutput) output;

        List<Output> results = new ArrayList<>();
        int size = listOutput.content().size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < nodeProcessors.size(); j++) {
                eachNext(nodeProcessors.get(j), i, j, results);
            }
        }

        List<Object> collect = results.stream().map(ro -> ro.content()).toList();
        this.output = new ListOutput(collect);
    }

    private void eachNext(NodeProcessor<? extends Input> nodeProcessor, int i, int j, List<Output> results) {

        ItemImpl item = new ItemImpl(nodeProcessor, i, j);
        item.process();
        if (nodeProcessor.nexts().get(0) instanceof ForNodeProcessor.EndNodeProcessor) {
            results.add(item.output);
        }else {
            eachNext(nodeProcessor.nexts().get(0), i, j, results);
        }
    }

    public ForNodeProcessor.StartNodeProcessor getForStartNode() {
        return forStartNode;
    }

    public void setForStartNode(ForNodeProcessor.StartNodeProcessor forStartNode) {
        this.forStartNode = forStartNode;
    }

    public ForNodeProcessor.EndNodeProcessor getForEndNode() {
        return forEndNode;
    }

    public void setForEndNode(ForNodeProcessor.EndNodeProcessor forEndNode) {
        this.forEndNode = forEndNode;
    }

    public List<NodeProcessor<? extends Input>> getNodeProcessors() {
        return nodeProcessors;
    }

    public void setNodeProcessors(List<NodeProcessor<? extends Input>> nodeProcessors) {
        this.nodeProcessors = nodeProcessors;
    }

    public static class StartNodeProcessor extends CollectionToListProcessor
            implements ForNodeProcessor.StartNodeProcessor {

    }

    public static class EndNodeProcessor extends AbstractNodeProcessor<EmptyInput>
            implements ForNodeProcessor.EndNodeProcessor {

        @Override
        public void doProcess() {
            output = prevs.get(0).output();
        }
    }

    public class ItemImpl implements ForNodeProcessor.Item {

        private NodeProcessor agent;
        private int level;
        private int index;
        private Output output;


        public ItemImpl(NodeProcessor agent, int level, int index) {

            this.agent = agent;
            this.level = level;
            this.index = index;
        }

        @Override
        public NodeProcessor agent() {
            return this.agent;
        }

        @Override
        public int level() {
            return this.level;
        }

        @Override
        public int index() {
            return this.index;
        }

        @Override
        public Output output() {
            return this.output;
        }

        @Override
        public void process() {

//            if (agent.input() != null) {
//                List<FieldInject> fieldInjects = agent.input().fieldConfigs();
//                if (fieldInjects != null) {
//                    for (FieldInject fc : fieldInjects) {
//                        ListOutput listOutput = (ListOutput) fc.source().get();
//                        fc.setV().accept(agent.input(), listOutput.content().get(level).toString());
//                    }
//                }
//            }
            if (agent.input() != null && agent instanceof ModelNodeProcessor mnp) {
                Output<?> prevOutput = prevs.get(0).output();
                if (prevOutput instanceof ListOutput<?> lop) {
                    mnp.input().setMsg(((StringOutput) lop.content().get(level)).content());
                } else {
                    mnp.input.setMsg((String) prevOutput.content());
                }
            }
            agent.process();
            output = agent.output();
        }

    }
}
