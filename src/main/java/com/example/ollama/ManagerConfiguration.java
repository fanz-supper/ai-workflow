package com.example.ollama;

import com.example.ollama.manager.graph.ProcessorAssembler;
import com.example.ollama.manager.graph.assembler.ProcessorAssemblerImpl;
import com.example.ollama.manager.graph.builder.*;
import com.example.ollama.manager.graph.expression.Expression;
import com.example.ollama.manager.graph.expression.OutputIdentityExpression;
import com.example.ollama.workflow.model.ModelEuFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title: ManagerConfiguration
 * @description:
 * @author: zhangfan
 */
@Configuration
public class ManagerConfiguration {


    @Bean
    public Expression expression() {
        return new OutputIdentityExpression();
    }

    @Bean
    public ProcessorAssembler integration() {
        return new ProcessorAssemblerImpl();
    }

    @Bean
    public NodeBuilderFactory nodeBuilderFactory(ModelEuFactory modelEuFactory, Expression expression) {

        return new NodeBuilderFactory()
                .register("ModelNode", new ModelNodeProcessorBuilder(modelEuFactory, expression))
                .register("ForStartNode", new ForStartNodeProcessorBuilder())
                .register("ForEndNode", new ForEndNodeProcessorBuilder())
                .register("FileWriteNode", new JavaFileWriteProcessorBuilder(expression));
    }
}
