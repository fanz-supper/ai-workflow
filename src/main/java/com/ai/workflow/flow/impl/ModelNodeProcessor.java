package com.ai.workflow.flow.impl;

import com.ai.workflow.ModelEu;
import com.ai.workflow.metadata.Output;
import com.ai.workflow.metadata.base.ModelInput;
import com.ai.workflow.model.ModelEuFactory;

/**
 * @title: ModelProcessor
 * @description:
 * @author: zhangfan
 */
public class ModelNodeProcessor extends AbstractNodeProcessor<ModelInput> {

    private ModelEuFactory modelEuFactory;

    public ModelNodeProcessor(ModelInput modelInput, ModelEuFactory modelEuFactory) {
        this.input = modelInput;
        this.modelEuFactory = modelEuFactory;
    }


    @Override
    public void doProcess() {

        ModelEu<Output<?>> modelEu = modelEuFactory.get(input());
        super.setOutput(modelEu.call());
    }

}
