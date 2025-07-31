package com.ai.workflow.prompt;

import com.ai.workflow.PromptEu;
import com.ai.workflow.metadata.PromptInput;
import com.ai.workflow.repository.PromptTemplateFactory;
import org.apache.commons.lang3.text.StrSubstitutor;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @title: PromptEuImpl
 * @description:
 * @author: zhangfan
 */
public class PromptEuImpl implements PromptEu {

    private PromptTemplateFactory promptTemplateFactory;

    public PromptEuImpl(PromptTemplateFactory promptTemplateFactory) {
        this.promptTemplateFactory = promptTemplateFactory;
    }

    @Override
    public String prompt(PromptInput input) {

        String prompt = input.getMsg();

        if (input != null && StringUtils.hasText(input.getPromptTemplateKey())) {
            String template = promptTemplateFactory.getByKey(input.getPromptTemplateKey());
            prompt = StrSubstitutor.replace(template, Map.of("msg", input.getMsg()));
        }

        return prompt;
    }

}
