package com.ai.workflow.flow.impl;

import com.ai.workflow.flow.IfProcessor;
import com.ai.workflow.flow.NodeProcessor;
import com.ai.workflow.metadata.TrueCondition;

/**
 * @title: IfProcessorImpl
 * @description:
 * @author: zhangfan
 */
public class IfNodeProcessorImpl extends AbstractNodeProcessor implements IfProcessor {

    private TrueCondition trueCondition;
    private NodeProcessor trueProcessor;

    private NodeProcessor falseProcessor;


    public IfNodeProcessorImpl(TrueCondition trueCondition, NodeProcessor trueProcessor, NodeProcessor falseProcessor) {
        this.trueCondition = trueCondition;
        this.trueProcessor = trueProcessor;
        this.falseProcessor = falseProcessor;
    }

    @Override
    public TrueCondition trueCondition() {
        return this.trueCondition;
    }

    @Override
    public NodeProcessor trueProcessor() {
        return this.trueProcessor;
    }

    @Override
    public NodeProcessor falseProcessor() {
        return this.falseProcessor;
    }

    @Override
    public void doProcess() {

    }


}
