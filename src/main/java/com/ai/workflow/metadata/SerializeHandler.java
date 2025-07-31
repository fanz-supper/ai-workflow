package com.ai.workflow.metadata;

/**
 * @title: SerializeHandler
 * @description:
 * @author: zhangfan
 * @data: 2025年05月19日 19:19
 */
public interface SerializeHandler<INPUT, OUTPUT> {

    OUTPUT handle(INPUT input);
}
