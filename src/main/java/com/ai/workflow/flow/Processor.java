package com.ai.workflow.flow;

/**
 * @title: Processor
 * @description: 流程过程中的处理器
 * @author: zhangfan
 * @data: 2025年03月14日 16:57
 */
public interface Processor {

    void process();

    Status status();

    enum Status {
        _init, _finish, _break
    }
}
