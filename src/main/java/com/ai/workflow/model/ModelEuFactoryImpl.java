package com.ai.workflow.model;

import com.ai.workflow.DataConvertEu;
import com.ai.workflow.EditorEu;
import com.ai.workflow.ModelEu;
import com.ai.workflow.PromptEu;
import com.ai.workflow.data.converter.DataConverterFactory;
import com.ai.workflow.llm.LLMEu;
import com.ai.workflow.llm.LLMFactory;
import com.ai.workflow.metadata.base.ModelInput;

/**
 * @title: ModelEuFactoryImpl
 * @description:
 * @author: zhangfan
 */
public class ModelEuFactoryImpl implements ModelEuFactory {

    private PromptEu promptEu;
    private EditorEu<String> editorEu;
    private DataConverterFactory dataConverterFactory;
    private LLMFactory llmFactory;

    public ModelEuFactoryImpl(PromptEu promptEu, EditorEu<String> editorEu, DataConverterFactory dataConverterFactory,
                              LLMFactory llmFactory) {
        this.promptEu = promptEu;
        this.editorEu = editorEu;
        this.dataConverterFactory = dataConverterFactory;
        this.llmFactory = llmFactory;
    }

    @Override
    public PromptEu promptEu() {
        return this.promptEu;
    }

    @Override
    public EditorEu editorEu() {
        return this.editorEu;
    }

    @Override
    public DataConverterFactory dataConverterFactory() {
        return this.dataConverterFactory;
    }

    @Override
    public LLMFactory llmFactory() {
        return this.llmFactory;
    }

    @Override
    public ModelEu get(ModelInput modelInput) {

        DataConvertEu dataConvertEu = dataConverterFactory().get(modelInput);
        LLMEu llmEu = llmFactory().get(modelInput);

        ModelEuImpl modelEu = new ModelEuImpl(modelInput, promptEu(), editorEu(), dataConvertEu, llmEu);

        return modelEu;
    }
}
