package com.example.ollama.workflow.model;

import com.example.ollama.workflow.DataConvertEu;
import com.example.ollama.workflow.EditorEu;
import com.example.ollama.workflow.ModelEu;
import com.example.ollama.workflow.PromptEu;
import com.example.ollama.workflow.data.converter.DataConverterFactory;
import com.example.ollama.workflow.llm.LLMEu;
import com.example.ollama.workflow.llm.LLMFactory;
import com.example.ollama.workflow.metadata.base.ModelInput;

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
