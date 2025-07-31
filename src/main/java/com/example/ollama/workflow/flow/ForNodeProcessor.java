package com.example.ollama.workflow.flow;


import com.example.ollama.workflow.metadata.Input;
import com.example.ollama.workflow.metadata.Output;
import com.example.ollama.workflow.metadata.base.EmptyInput;

/**
 * @title: ForEu
 * @description:
 * @author: zhangfan
 * @data: 2025年03月13日 20:15
 */
public interface ForNodeProcessor<T extends Input> extends NodeProcessor<T> {


    interface StartNodeProcessor extends NodeProcessor<EmptyInput> {

    }

    interface EndNodeProcessor extends NodeProcessor<EmptyInput> {

    }

    interface Item {

        NodeProcessor agent();

        int level();

        int index();

        void process();

        Output output();


    }

}
