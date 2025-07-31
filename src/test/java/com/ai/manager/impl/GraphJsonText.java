package com.ai.manager.impl;

/**
 * @title: GraphJsonText
 * @description:
 * @author: zhangfan
 * @data: 2025年05月11日 14:05
 */
interface GraphJsonText {

    String str = """
            {
              "nodes": [
                {
                  "id": "13c5e54f-704d-4375-a5ba-99220f5deffb",
                  "type": "special",
                  "initialized": false,
                  "position": {
                    "x": 390,
                    "y": 222.203125
                  },
                  "data": {
                    "label": "讲笑话",
                    "options": {
                      "name": "Model Node",
                      "serviceType": "ModelNode",
                      "type": "special",
                      "bgColor": "#81C7D4"
                    },
                    "params": {
                      "name": "讲笑话",
                      "type": "Qwen3.0",
                      "templateId": "",
                      "msg": "请一个笑话",
                      "msgExpression": "",
                      "dataConverterId": "ETLYaml"
                    }
                  }
                }
              ],
              "edges": [],
              "position": [
                0,
                0
              ],
              "zoom": 1,
              "viewport": {
                "x": 0,
                "y": 0,
                "zoom": 1
              }
            } 
            """;

}
