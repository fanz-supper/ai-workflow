package com.ai.workflow.flow.impl;

import com.ai.workflow.flow.NodeProcessor;
import com.ai.workflow.metadata.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: AbstractProcessor
 * @description:
 * @author: zhangfan
 */
public abstract class AbstractNodeProcessor<T extends Input> implements NodeProcessor<T> {

    protected Map<String, Attribute<?>> attributeMap = new HashMap<>();
    protected SerializeHandler inputSerializeHandler;
    protected SerializeHandler outputSerializeHandler;
    protected T input;
    protected List<NodeProcessor<? extends Input>> prevs;
    protected List<NodeProcessor<? extends Input>> nexts;
    protected Output<?> output;
    protected Status status = Status._init;


    @Override
    public void process() {
        preProcess();
        doProcess();
        status = Status._finish;
    }

    public void preProcess() {
        if (input != null && input.fieldConfigs() != null) {
            for (FieldInject fi : input.fieldConfigs()) {
                fi.setV().accept(input, fi.source().get());
            }
        }
    }

    abstract void doProcess();

    @Override
    public <OUTPUT> SerializeHandler<T, OUTPUT> inputSerializeHandler() {
        return this.inputSerializeHandler;
    }

    @Override
    public <OUTPUT> SerializeHandler<Output<?>, OUTPUT> outputSerializeHandler() {
        return this.outputSerializeHandler;
    }

    @Override
    public void setInputSerializeHandler(SerializeHandler inputSerializeHandler) {
        this.inputSerializeHandler = inputSerializeHandler;
    }

    @Override
    public void setOutputSerializeHandler(SerializeHandler outputSerializeHandler) {
        this.outputSerializeHandler = outputSerializeHandler;
    }

    @Override
    public <OUTPUT> OUTPUT doInputSerialize() {
        return this.<OUTPUT>inputSerializeHandler().handle(input);
    }

    @Override
    public <OUTPUT> OUTPUT doOutputSerialize() {
        return this.<OUTPUT>outputSerializeHandler().handle(output);
    }

    @Override
    public Map<String, Attribute<?>> attributeMap() {
        return this.attributeMap;
    }

    @Override
    public Status status() {
        return status;
    }

    @Override
    public <V> V getAttrV(String key) {

        Attribute<?> attribute = attributeMap().get(key);
        if (attribute == null) {
            return null;
        }
        return (V) attribute.getV();
    }

    @Override
    public NodeProcessor<T> putAttr(Attribute<?> attribute) {
        attributeMap.put(attribute.getK(), attribute);
        return this;
    }

    @Override
    public T input() {
        return this.input;
    }

    @Override
    public List<NodeProcessor<? extends Input>> prevs() {
        return this.prevs;
    }

    @Override
    public List<NodeProcessor<? extends Input>> nexts() {
        return this.nexts;
    }

    @Override
    public void setPrevs(List<NodeProcessor<? extends Input>> prevs) {
        this.prevs = prevs;
    }

    @Override
    public void setNexts(List<NodeProcessor<? extends Input>> nexts) {
        this.nexts = nexts;
    }

    @Override
    public void addPre(NodeProcessor pre) {
        if (prevs == null) {
            prevs = new ArrayList<>();
        }
        prevs.add(pre);
    }

    @Override
    public void addNext(NodeProcessor next) {
        if (nexts == null) {
            nexts = new ArrayList<>();
        }
        nexts.add(next);
    }

    @Override
    public Output<?> output() {
        return this.output;
    }


    @Override
    public void setInput(T input) {
        this.input = input;
    }

    @Override
    public void setOutput(Output<?> output) {
        this.output = output;
    }
}
