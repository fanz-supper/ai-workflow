package com.example.ollama.workflow.metadata.base;

import com.example.ollama.workflow.metadata.DataConverterInput;
import com.example.ollama.workflow.metadata.FieldInject;
import com.example.ollama.workflow.metadata.PromptInput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @title: ModelInput
 * @description:
 * @author: zhangfan
 */
@Getter
@Setter
@NoArgsConstructor
public class ModelInput extends AbstractInput implements PromptInput, DataConverterInput {

    private String promptTemplateKey;
    private String msg;
    private String modelType;
    private String dataConverterKey;
    private String editorKey;
    private String prompt;

    public ModelInput(String msg) {
        this.msg = msg;
    }

    public ModelInput(String msg, String promptTemplateKey) {
        this.msg = msg;
        this.promptTemplateKey = promptTemplateKey;
    }

    public ModelInput(String msg, String promptTemplateKey, String dataConverterKey) {
        this.promptTemplateKey = promptTemplateKey;
        this.msg = msg;
        this.dataConverterKey = dataConverterKey;
    }

    public ModelInput(String msg, String promptTemplateKey, String dataConverterKey, List<FieldInject> fieldInjects) {
        this.promptTemplateKey = promptTemplateKey;
        this.msg = msg;
        this.dataConverterKey = dataConverterKey;
        super.fieldInjects = fieldInjects;
    }

}
