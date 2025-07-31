package com.ai.manager.graph.attr;

import com.ai.workflow.metadata.Attribute;

/**
 * @title: NodeIdAttribute
 * @description:
 * @author: zhangfan
 */
public class NodeIdAttr implements Attribute<String> {

    public static final String KEY = "nodeId";
    public static final String NODE_KEY = "id";
    private String v;


    public NodeIdAttr(String v) {
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
