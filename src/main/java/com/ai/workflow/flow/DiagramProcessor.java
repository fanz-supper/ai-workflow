package com.ai.workflow.flow;

import com.ai.workflow.metadata.Input;

import java.util.List;

/**
 * @title: FlowProcessor
 * @description: 画布流程执行器
 * @author: zhangfan
 * @data: 2025年03月14日 20:06
 */
public interface DiagramProcessor extends Processor {

    List<NodeProcessor<? extends Input>> headers();
}
