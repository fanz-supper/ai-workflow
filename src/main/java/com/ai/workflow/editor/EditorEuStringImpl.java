package com.ai.workflow.editor;

import com.ai.workflow.EditorEu;
import com.ai.workflow.metadata.Output;

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
