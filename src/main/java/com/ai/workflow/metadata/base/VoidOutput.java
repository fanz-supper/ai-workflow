package com.ai.workflow.metadata.base;

/**
 * @title: VoidOutput
 * @description:
 * @author: zhangfan
 */
public class VoidOutput extends AbstractOutput<Void> {

    @Override
    public Void content() {
        return null;
    }
}
