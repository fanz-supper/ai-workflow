package com.ai.manager.graph.builder;

import com.ai.manager.graph.Graph;
import com.ai.manager.graph.attr.NodeIdAttr;
import com.ai.manager.graph.attr.NodeNameAttr;
import com.ai.manager.graph.attr.NodeServiceTypeAttr;
import com.ai.manager.graph.expression.Expression;
import com.ai.workflow.flow.NodeProcessor;
import com.ai.workflow.flow.impl.ModelNodeProcessor;
import com.ai.workflow.metadata.FieldInject;
import com.ai.workflow.metadata.base.ModelInput;
import com.ai.workflow.metadata.serialize.handler.InputToJsonString;
import com.ai.workflow.metadata.serialize.handler.OutputToString;
import com.ai.workflow.model.ModelEuFactory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @title: ModelNodeProcessorBuilder
 * @description:
 * @author: zhangfan
 */
@NoArgsConstructor
@AllArgsConstructor
public class ModelNodeProcessorBuilder implements NodeBuilder<ModelNodeProcessor> {

    private ModelEuFactory modelEuFactory;
    private Expression expression;

    @Override
    public ModelNodeProcessor build(Graph.Node node, Map<String, NodeProcessor> buildMap) {

        Map<String, Object> params = node.getData().getParams();
        ModelInput modelInput = toInput(params, buildMap);

        ModelNodeProcessor processor = new ModelNodeProcessor(modelInput, modelEuFactory);
        processor.setInputSerializeHandler(new InputToJsonString());
        processor.setOutputSerializeHandler(new OutputToString());


        NodeIdAttr nodeIdAttr = new NodeIdAttr(node.getId());
        NodeNameAttr nodeNameAttr = new NodeNameAttr(String.valueOf(params.get(NodeNameAttr.NODE_KEY)));
        NodeServiceTypeAttr nodeServiceTypeAttr = new NodeServiceTypeAttr(node.getData().getOptions().getServiceType());

        processor
                .putAttr(nodeIdAttr)
                .putAttr(nodeNameAttr)
                .putAttr(nodeServiceTypeAttr);

        return processor;
    }

    private ModelInput toInput(Map<String, Object> params, Map<String, NodeProcessor> buildMap) {

        ModelInput modelInput = new ModelInput();
        modelInput.setMsg(String.valueOf(params.get("msg")));
        modelInput.setModelType(String.valueOf(params.get("type")));
        modelInput.setDataConverterKey(String.valueOf(params.get("dataConverterId")));
        modelInput.setPromptTemplateKey(String.valueOf(params.get("promptTemplateId")));

        if (params.containsKey("msgExpression")) {

            Map<String, Object> expressionMap = (Map<String, Object>) params.get("msgExpression");
            if (StringUtils.hasText(expressionMap.get("nodeId").toString())) {
                modelInput.setFieldConfigs(List.of(convertMsgExpression(expressionMap, buildMap)));
            }
        }

        return modelInput;
    }

    private FieldInject<ModelInput, String> convertMsgExpression(Map<String, Object> expressionMap, Map<String, NodeProcessor> buildMap) {

        return expression.convert(expressionMap, buildMap,
                (modelInput, str) -> modelInput.setMsg(str));
    }

}
