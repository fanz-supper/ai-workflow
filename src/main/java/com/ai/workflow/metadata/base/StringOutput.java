package com.ai.workflow.metadata.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @title: BaseOutput
 * @description:
 * @author: zhangfan
 */
@Getter
@Setter
@NoArgsConstructor
public class StringOutput extends AbstractOutput<String> {

    private String content;

    public StringOutput(String content) {
        this.content = content;
    }

    @Override
    public String content() {
        return this.content;
    }

}
