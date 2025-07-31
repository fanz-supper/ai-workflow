package com.example.ollama.workflow.flow.impl;

import com.example.ollama.workflow.ModelEu;
import com.example.ollama.workflow.metadata.Output;
import com.example.ollama.workflow.metadata.base.ModelInput;
import com.example.ollama.workflow.model.ModelEuFactory;

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
