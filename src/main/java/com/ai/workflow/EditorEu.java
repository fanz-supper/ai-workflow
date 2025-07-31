package com.ai.workflow;

import com.ai.workflow.metadata.Output;

/**
 * @title: EditorEU
 * @description:
 * @author: zhangfan
 * @data: 2025年03月13日 19:25
 */
public interface EditorEu<T> {

    Output<T> edit(Output<T> output);
}
