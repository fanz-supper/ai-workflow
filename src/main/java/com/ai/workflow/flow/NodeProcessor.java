package com.ai.workflow.flow;

import com.ai.workflow.metadata.Attribute;
import com.ai.workflow.metadata.Input;
import com.ai.workflow.metadata.Output;
import com.ai.workflow.metadata.SerializeHandler;

import java.util.List;
import java.util.Map;

/**
 * @title: NodeProcessor
 * @description:
 * @author: zhangfan
 * @data: 2025年03月14日 20:10
 */
public interface NodeProcessor<T extends Input> extends Processor {

    <OUTPUT> SerializeHandler<T, OUTPUT> inputSerializeHandler();

    <OUTPUT> SerializeHandler<Output<?>, OUTPUT> outputSerializeHandler();

    void setInputSerializeHandler(SerializeHandler inputSerializeHandler);

    <OUTPUT> OUTPUT doInputSerialize();

    void setOutputSerializeHandler(SerializeHandler outputSerializeHandler);

    <OUTPUT> OUTPUT doOutputSerialize();

    Map<String, Attribute<?>> attributeMap();

    <V> V getAttrV(String key);

    NodeProcessor<T> putAttr(Attribute<?> attribute);

    T input();

    List<NodeProcessor<? extends Input>> prevs();

    List<NodeProcessor<? extends Input>> nexts();

    Output<?> output();

    void setInput(T input);

    void setPrevs(List<NodeProcessor<? extends Input>> prevs);

    void setNexts(List<NodeProcessor<? extends Input>> nexts);

    void addPre(NodeProcessor pre);

    void addNext(NodeProcessor next);

    void setOutput(Output<?> output);

}
