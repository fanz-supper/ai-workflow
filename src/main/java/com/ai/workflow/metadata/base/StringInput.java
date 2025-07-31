package com.ai.workflow.metadata.base;

import com.ai.workflow.metadata.FieldInject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @title: StringInput
 * @description:
 * @author: zhangfan
 */
@Getter
@Setter
@NoArgsConstructor
public class StringInput extends AbstractInput {

    private String content;

    public StringInput(String content) {
        this.content = content;
    }

    public StringInput(String content, List<FieldInject> fieldInjects) {
        this.content = content;
        super.fieldInjects = fieldInjects;
    }


    public String content() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
