package com.example.ollama.manager.graph.attr;

import com.example.ollama.workflow.metadata.Attribute;

/**
 * @title: NodeNameAttr
 * @description:
 * @author: zhangfan
 */
public class NodeNameAttr implements Attribute<String> {

    public static final String KEY = "nodeName";
    public static final String NODE_KEY = "name";
    private String v;

    public NodeNameAttr(String v) {
        this.v = v;
    }

    @Override
    public String getK() {
        return KEY;
    }

    @Override
    public String getNodeK() {
        return NODE_KEY;
    }

    @Override
    public String getV() {
        return this.v;
    }

}
