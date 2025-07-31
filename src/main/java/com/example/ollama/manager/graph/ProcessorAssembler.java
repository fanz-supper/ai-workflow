package com.example.ollama.manager.graph;

import com.example.ollama.workflow.flow.NodeProcessor;
import com.example.ollama.workflow.metadata.Input;

import java.util.List;

/**
 * @title: Integration
 * @description:
 * @author: zhangfan
 * @data: 2025年05月09日 17:17
 */
public interface ProcessorAssembler {

    List<NodeProcessor<? extends Input>> assemble(List<NodeProcessor<? extends Input>> headers);
}
