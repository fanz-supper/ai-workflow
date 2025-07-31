package com.example.ollama.manager.graph;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONPath;
import org.junit.jupiter.api.Test;

/**
 * @title: JSONPathTest
 * @description:
 * @author: zhangfan
 */
public class JSONPathTest {


    @Test
    void test() {

        JSONObject jsonObject = JSON.parseObject(GraphJsonText.str);
        Object eval = jsonObject.eval(JSONPath.of("$.nodes[*].id"));
        System.out.println(eval);


    }

}
