package com.ai.workflow.model;

import com.ai.workflow.DataConvertEu;
import com.ai.workflow.EditorEu;
import com.ai.workflow.ModelEu;
import com.ai.workflow.PromptEu;
import com.ai.workflow.llm.LLMEu;
import com.ai.workflow.metadata.Output;
import com.ai.workflow.metadata.base.ModelInput;
import com.ai.workflow.metadata.base.StringOutput;

/**
 * @title: ModelEuImpl
 * @description:
 * @author: zhangfan
 */
public class ModelEuImpl implements ModelEu {

    private ModelInput input;

    private PromptEu promptEu;
    private EditorEu editorEu;
    private DataConvertEu dataConvertEu;
    private LLMEu llmEu;

    private Output output;

    public ModelEuImpl(ModelInput input, PromptEu promptEu, EditorEu editorEu, DataConvertEu dataConvertEu, LLMEu llmEu) {
        this.input = input;
        this.promptEu = promptEu;
        this.editorEu = editorEu;
        this.dataConvertEu = dataConvertEu;
        this.llmEu = llmEu;
    }

    @Override
    public DataConvertEu dataConvertEu() {
        return this.dataConvertEu;
    }

    @Override
    public LLMEu llmEu() {
        return this.llmEu;
    }

    @Override
    public PromptEu promptEu() {
        return this.promptEu;
    }

    @Override
    public ModelInput input() {
        return this.input;
    }


    @Override
    public EditorEu editorEu() {
        return this.editorEu;
    }

    @Override
    public Output output() {
        return this.output;
    }

    @Override
    public Output call() {

        String prompt = promptEu().prompt(input);
        input.setPrompt(prompt);

        StringOutput stringOutput = llmEu().call(prompt);

        Output convert = dataConvertEu().convert(stringOutput);
//
//        Output edit = editorEu().edit(convert);

        this.output = convert;

        return output();
    }
}
