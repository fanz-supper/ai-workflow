package com.ai.workflow.metadata.base;

import com.ai.workflow.metadata.FieldInject;
import com.ai.workflow.metadata.Input;

import java.util.List;

/**
 * @title: AbstractInput
 * @description:
 * @author: zhangfan
 */
public abstract class AbstractInput implements Input {

    public List<FieldInject> fieldInjects;

    @Override
    public List<FieldInject> fieldConfigs() {

        return this.fieldInjects;
    }

    public void setFieldConfigs(List<FieldInject> fieldInjects) {
        this.fieldInjects = fieldInjects;
    }

}
