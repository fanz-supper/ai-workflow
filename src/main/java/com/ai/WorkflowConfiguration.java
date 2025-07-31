package com.ai;

import com.ai.manager.PromptTemplateService;
import com.ai.workflow.DataConvertEu;
import com.ai.workflow.EditorEu;
import com.ai.workflow.PromptEu;
import com.ai.workflow.data.converter.DataConverterDomainListEuImpl;
import com.ai.workflow.data.converter.DataConverterFactory;
import com.ai.workflow.data.converter.DataConverterJavaEuImpl;
import com.ai.workflow.data.converter.DataConverterYamlEuImpl;
import com.ai.workflow.editor.EditorEuStringImpl;
import com.ai.workflow.llm.LLMEu;
import com.ai.workflow.llm.LLMFactory;
import com.ai.workflow.metadata.base.StringOutput;
import com.ai.workflow.model.ModelEuFactory;
import com.ai.workflow.model.ModelEuFactoryImpl;
import com.ai.workflow.print.BlockPrint;
import com.ai.workflow.prompt.PromptEuImpl;
import com.ai.workflow.repository.PromptTemplateFactory;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.Map;

/**
 * @title: WorkFlowConfiguration
 * @description:
 * @author: zhangfan
 */
@Configuration
public class WorkflowConfiguration {

    @Bean
    public PromptTemplateFactory promptTemplateFactory(PromptTemplateService promptTemplateService) {
        return key -> promptTemplateService.queryById(key).getTemplate();
    }

    @Bean
    public PromptEu promptEu(PromptTemplateFactory repository) {
        return new PromptEuImpl(repository);
    }

    @Bean
    public EditorEu<String> editorEu() {
        return new EditorEuStringImpl();
    }

    @Bean
    public DataConverterFactory dataConverterFactory() {
        return input -> {

            Map<String, DataConvertEu> yamlMap =
                    Map.of("ETLYaml", new DataConverterYamlEuImpl(), "JavaYaml", new DataConverterJavaEuImpl(),
                            "DomainListYaml", new DataConverterDomainListEuImpl());

            return yamlMap.get(input.getDataConverterKey());
        };
    }

    @Bean
    public LLMFactory llmFactory(OllamaChatModel chatModel) {
        return input -> (LLMEu) msg ->
        {
            BlockPrint.print("prompt", msg);
            Flux<String> flux = chatModel.stream(msg);
            StringBuffer sb = new StringBuffer();
            flux.doOnNext(rs -> {
                BlockPrint.print("response:\n", rs);
                sb.append(rs);
            }).blockLast();

//            String result = chatModel.call(msg);
//            System.out.println(result);
            return new StringOutput(sb.toString());
        };
    }


    @Bean
    public ModelEuFactory modelEuFactory(PromptEu promptEu, EditorEu<String> editorEu, DataConverterFactory dataConverterFactory,
                                         LLMFactory llmFactory) {
        return new ModelEuFactoryImpl(promptEu, editorEu, dataConverterFactory, llmFactory);
    }
}
