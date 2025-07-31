package com.ai.manager.graph.builder;

import com.ai.manager.graph.Graph;
import com.ai.manager.graph.attr.NodeIdAttr;
import com.ai.manager.graph.expression.Expression;
import com.ai.workflow.flow.NodeProcessor;
import com.ai.workflow.flow.impl.JavaFileWriteProcessor;
import com.ai.workflow.metadata.FieldInject;
import com.ai.workflow.metadata.base.JavaFileInput;
import com.ai.workflow.metadata.serialize.handler.InputToJsonString;
import com.ai.workflow.metadata.serialize.handler.OutputToEmptyString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @title: JavaFileWriteProcessorBuilder
 * @description:
 * @author: zhangfan
 */
@AllArgsConstructor
@NoArgsConstructor
public class JavaFileWriteProcessorBuilder implements NodeBuilder<JavaFileWriteProcessor> {

    private Expression expression;

    @Override
    public JavaFileWriteProcessor build(Graph.Node node, Map<String, NodeProcessor> buildMap) {

        JavaFileInput javaFileInput = toInput(node.getData().getParams(), buildMap);
        JavaFileWriteProcessor processor = new JavaFileWriteProcessor(javaFileInput);
        processor.setInputSerializeHandler(new InputToJsonString());
        processor.setOutputSerializeHandler(new OutputToEmptyString());

        NodeIdAttr nodeIdAttr = new NodeIdAttr(node.getId());
        processor.attributeMap().put(nodeIdAttr.getK(), nodeIdAttr);

        return processor;
    }

    private JavaFileInput toInput(Map<String, Object> params, Map<String, NodeProcessor> buildMap) {

        JavaFileInput javaFileInput = new JavaFileInput();
        javaFileInput.setDir(String.valueOf(params.get("dir")));

        if (params.containsKey("contentExpression")) {
            javaFileInput.setFieldConfigs(List.of(convertContentExpression((Map<String, Object>) params.get("contentExpression"), buildMap)));

        }

        return javaFileInput;
    }


    private FieldInject convertContentExpression(Map<String, Object> expressionMap, Map<String, NodeProcessor> buildMap) {

        return expression.<JavaFileInput, String>convert(expressionMap, buildMap,
                (modelInput, str) -> modelInput.setContent(str));
    }
}
