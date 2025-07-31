package com.ai.manager.graph;

import com.ai.manager.graph.assembler.ProcessorAssemblerImpl;
import com.ai.manager.graph.builder.*;
import com.ai.manager.graph.expression.Expression;
import com.ai.manager.graph.expression.OutputIdentityExpression;
import com.ai.workflow.flow.NodeProcessor;
import com.ai.workflow.flow.impl.DiagramProcessorImpl;
import com.ai.workflow.metadata.Input;
import com.ai.workflow.model.ModelEuFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @title: ParserTest
 * @description:
 * @author: zhangfan
 * @data: 2025年05月09日 13:42
 */
@SpringBootTest
class ParserTest {

    @Autowired
    private ModelEuFactory modelEuFactory;
    private NodeBuilderFactory nodeBuilderFactory;
    private ProcessorAssembler processorAssembler;
    private Expression expression;


    @BeforeEach
    void init() {

        expression = new OutputIdentityExpression();
        nodeBuilderFactory = new NodeBuilderFactory();

        nodeBuilderFactory.register("ModelNode", new ModelNodeProcessorBuilder(modelEuFactory, expression))
                .register("ForStartNode", new ForStartNodeProcessorBuilder())
                .register("ForEndNode", new ForEndNodeProcessorBuilder())
                .register("FileWriteNode", new JavaFileWriteProcessorBuilder(expression));

        processorAssembler = new ProcessorAssemblerImpl();
    }

    @Test
    void parse() {

        Parser parser = new Parser(nodeBuilderFactory, processorAssembler);
        List<NodeProcessor<? extends Input>> headers = parser.parse(GraphJsonText.str);

        DiagramProcessorImpl diagramProcessor = new DiagramProcessorImpl(headers);

        diagramProcessor.process();

    }


}
