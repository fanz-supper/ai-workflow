package com.example.ollama.workflow.flow.impl;

import com.example.ollama.workflow.flow.DiagramProcessor;
import com.example.ollama.workflow.flow.NodeProcessor;
import com.example.ollama.workflow.metadata.Input;

import java.util.List;


/**
 * @title: DiagramProcessorImpl
 * @description:
 * @author: zhangfan
 */
public class DiagramProcessorImpl implements DiagramProcessor {

    private List<NodeProcessor<? extends Input>> headers;
    private Status status = Status._init;

    public DiagramProcessorImpl(List<NodeProcessor<? extends Input>> headers) {
        this.headers = headers;
    }

    @Override
    public Status status() {
        return this.status;
    }

    @Override
    public List<NodeProcessor<? extends Input>> headers() {
        return this.headers;
    }

    @Override
    public void process() {

        doProcess(headers);
        status = Status._finish;
    }


    public void doProcess(List<NodeProcessor<? extends Input>> nexts) {

        if (nexts == null) {
            return;
        }

        for (NodeProcessor next : nexts) {

            next.process();

            if (next.status() == Status._break) {
                continue;
            }

            doProcess(next.nexts());
        }

    }
}

