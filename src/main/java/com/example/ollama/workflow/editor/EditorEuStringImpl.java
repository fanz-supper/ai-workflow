package com.example.ollama.workflow.editor;

import com.example.ollama.workflow.EditorEu;
import com.example.ollama.workflow.metadata.Output;

/**
 * @title: EditorEuImpl
 * @description:
 * @author: zhangfan
 */
public class EditorEuStringImpl implements EditorEu<String> {

    @Override
    public Output<String> edit(Output<String> output) {
        return output;
    }
}
