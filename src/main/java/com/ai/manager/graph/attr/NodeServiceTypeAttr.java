package com.ai.manager.graph.attr;

import com.ai.workflow.metadata.Attribute;

/**
 * @title: NodeServiceTypeAttr
 * @description:
 * @author: zhangfan
 */
public class NodeServiceTypeAttr implements Attribute<String> {

    public static final String KEY = "nodeServiceType";
    public static final String NODE_KEY = "serviceType";
    private String v;

    public NodeServiceTypeAttr(String v) {
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
