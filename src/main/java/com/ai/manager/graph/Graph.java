package com.ai.manager.graph;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @title: Graph
 * @description:
 * @author: zhangfan
 * @data: 2025年05月08日 22:39
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Graph {

    private List<Node> nodes;
    private List<Edge> edges;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Node {

        private List<Node> pres;
        private List<Node> nexts;

        private String id;
        private Data data;


        public String serviceType() {
            return data.options.serviceType;
        }

        public void addPre(Node node) {

            if (pres == null) {
                pres = new ArrayList<>();
            }
            pres.add(node);
        }

        public void addNext(Node node) {

            if (nexts == null) {
                nexts = new ArrayList<>();
            }
            nexts.add(node);
        }

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        public static class Data {

            private Options options;
            private Map<String, Object> params;

            @Getter
            @Setter
            @AllArgsConstructor
            @NoArgsConstructor
            public static class Options {
                private String serviceType;
            }
        }

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Edge {
        private String source;
        private String target;
    }

}
