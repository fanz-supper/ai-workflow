package com.ai.workflow.flow.impl;

import com.ai.workflow.flow.NodeProcessor;
import com.ai.workflow.metadata.Input;
import com.ai.workflow.metadata.Output;
import com.ai.workflow.metadata.base.EmptyInput;
import com.ai.workflow.metadata.base.ListOutput;

import java.util.List;
import java.util.Optional;

/**
 * @title: CollectionToListProcessor
 * @description:
 * @author: zhangfan
 */
public class CollectionToListProcessor extends AbstractNodeProcessor<EmptyInput> {

    @Override
    public void process() {
        doProcess();
    }

    @Override
    void doProcess() {

        Optional<NodeProcessor<? extends Input>> any = prevs.stream()
                .filter(np -> np.status() != Status._finish).findAny();
        if (any.isPresent()) {
            status = Status._break;
        } else {
            List<? extends Output<?>> list = prevs.stream().map(NodeProcessor::output).toList();
            output = new ListOutput<>(list);
            status = Status._finish;
        }
    }
}
