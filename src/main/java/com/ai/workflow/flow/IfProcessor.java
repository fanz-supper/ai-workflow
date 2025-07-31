package com.ai.workflow.flow;

import com.ai.workflow.metadata.TrueCondition;

/**
 * @title: IfEu
 * @description:
 * @author: zhangfan
 * @data: 2025年03月13日 20:14
 */
public interface IfProcessor extends NodeProcessor {

    TrueCondition trueCondition();

    NodeProcessor trueProcessor();

    NodeProcessor falseProcessor();

}
