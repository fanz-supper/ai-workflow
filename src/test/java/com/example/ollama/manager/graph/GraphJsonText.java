package com.example.ollama.manager.graph;

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
                        "id": "4f784858-16b6-4b03-83c5-be5a05a9be18",
                        "type": "special",
                        "initialized": false,
                        "position": {
                            "x": 302.25,
                            "y": 158
                        },
                        "data": {
                            "label": "1",
                            "options": {
                                "name": "Model Node",
                                "serviceType": "ModelNode",
                                "type": "special",
                                "bgColor": "#B8F1D2"
                            },
                            "params": {
                                "name": "1",
                                "type": "qwen2.5",
                                "promptTemplateId": "20250529211807193",
                                "msg": "HashMap",
                                "msgExpression": {
                                    "nodeId": ""
                                },
                                "dataConverterId": "ETLYaml"
                            }
                        }
                    },
                    {
                        "id": "4eff9dba-c786-462b-90b4-566b6145fe39",
                        "type": "special",
                        "initialized": false,
                        "position": {
                            "x": 648.5009360622698,
                            "y": 144.808829297794
                        },
                        "data": {
                            "label": "2",
                            "options": {
                                "name": "Model Node",
                                "serviceType": "ModelNode",
                                "type": "special",
                                "bgColor": "#B8F1D2"
                            },
                            "params": {
                                "name": "2",
                                "type": "qwen2.5",
                                "promptTemplateId": "20250529210832727",
                                "msg": "",
                                "msgExpression": {
                                    "nodeId": ""
                                },
                                "dataConverterId": "ETLYaml"
                            }
                        }
                    },
                    {
                        "id": "e46b53c3-5854-41ac-bb89-18bb2bfa7141",
                        "type": "special",
                        "initialized": false,
                        "position": {
                            "x": 481.058829297794,
                            "y": 329.6112042221969
                        },
                        "data": {
                            "label": "forstart",
                            "options": {
                                "name": "For Start Node",
                                "serviceType": "ForStartNode",
                                "type": "special",
                                "bgColor": "#CDD5E0"
                            },
                            "params": {
                                "name": "forend"
                            }
                        }
                    },
                    {
                        "id": "b2f0f952-1c52-4606-8ad7-64aebc0a429a",
                        "type": "special",
                        "initialized": false,
                        "position": {
                            "x": 488.8143476089152,
                            "y": 206.36672253331815
                        },
                        "data": {
                            "label": "3",
                            "options": {
                                "name": "Model Node",
                                "serviceType": "ModelNode",
                                "type": "special",
                                "bgColor": "#B8F1D2"
                            },
                            "params": {
                                "name": "3",
                                "type": "qwen2.5",
                                "promptTemplateId": "20250529210832727",
                                "msg": "",
                                "msgExpression": {
                                    "nodeId": ""
                                },
                                "dataConverterId": "ETLYaml"
                            }
                        }
                    },
                    {
                        "id": "834bb528-790d-4313-b727-49114c23b6bb",
                        "type": "special",
                        "initialized": false,
                        "position": {
                            "x": 475.49448168887875,
                            "y": 425.4889633777575
                        },
                        "data": {
                            "label": "item1",
                            "options": {
                                "name": "Model Node",
                                "serviceType": "ModelNode",
                                "type": "special",
                                "bgColor": "#B8F1D2"
                            },
                            "params": {
                                "name": "item1",
                                "type": "qwen2.5",
                                "promptTemplateId": "20250529210832727",
                                "msg": "",
                                "msgExpression": {
                                    "nodeId": ""
                                },
                                "dataConverterId": "ETLYaml"
                            }
                        }
                    },
                    {
                        "id": "fc1e286c-cb54-4395-9617-0e294727f4a4",
                        "type": "special",
                        "initialized": false,
                        "position": {
                            "x": 503.7610366222425,
                            "y": 500.73344506663636
                        },
                        "data": {
                            "label": "item2",
                            "options": {
                                "name": "Model Node",
                                "serviceType": "ModelNode",
                                "type": "special",
                                "bgColor": "#B8F1D2"
                            },
                            "params": {
                                "name": "item2",
                                "type": "qwen2.5",
                                "promptTemplateId": "20250529210832727",
                                "msg": null,
                                "msgExpression": {
                                    "nodeId": ""
                                },
                                "dataConverterId": "ETLYaml"
                            }
                        }
                    },
                    {
                        "id": "764a238b-9d89-41cb-bd72-a6ccf102c6ef",
                        "type": "special",
                        "initialized": false,
                        "position": {
                            "x": 529.3189298577666,
                            "y": 608.8933780266545
                        },
                        "data": {
                            "label": "forend",
                            "options": {
                                "name": "For End Node",
                                "serviceType": "ForEndNode",
                                "type": "special",
                                "bgColor": "#FCF098"
                            },
                            "params": {
                                "name": "forend"
                            }
                        }
                    }
                ],
                "edges": [
                    {
                        "id": "vueflow__edge-4f784858-16b6-4b03-83c5-be5a05a9be18-e46b53c3-5854-41ac-bb89-18bb2bfa7141",
                        "type": "default",
                        "source": "4f784858-16b6-4b03-83c5-be5a05a9be18",
                        "target": "e46b53c3-5854-41ac-bb89-18bb2bfa7141",
                        "sourceHandle": null,
                        "targetHandle": null,
                        "data": {},
                        "label": "",
                        "style": {
                            "strokeWidth": 1.5
                        },
                        "markerEnd": {
                            "type": "arrow"
                        },
                        "sourceX": 388.25000889470607,
                        "sourceY": 213.00000991068632,
                        "targetX": 567.0588381925,
                        "targetY": 325.61121253831084
                    },
                    {
                        "id": "vueflow__edge-b2f0f952-1c52-4606-8ad7-64aebc0a429a-e46b53c3-5854-41ac-bb89-18bb2bfa7141",
                        "type": "default",
                        "source": "b2f0f952-1c52-4606-8ad7-64aebc0a429a",
                        "target": "e46b53c3-5854-41ac-bb89-18bb2bfa7141",
                        "sourceHandle": null,
                        "targetHandle": null,
                        "data": {},
                        "label": "",
                        "style": {
                            "strokeWidth": 1.5
                        },
                        "markerEnd": {
                            "type": "arrow"
                        },
                        "sourceX": 574.8143565036213,
                        "sourceY": 261.3667145065003,
                        "targetX": 567.0588381925,
                        "targetY": 325.61121253831084
                    },
                    {
                        "id": "vueflow__edge-4eff9dba-c786-462b-90b4-566b6145fe39-e46b53c3-5854-41ac-bb89-18bb2bfa7141",
                        "type": "default",
                        "source": "4eff9dba-c786-462b-90b4-566b6145fe39",
                        "target": "e46b53c3-5854-41ac-bb89-18bb2bfa7141",
                        "sourceHandle": null,
                        "targetHandle": null,
                        "data": {},
                        "label": "",
                        "style": {
                            "strokeWidth": 1.5
                        },
                        "markerEnd": {
                            "type": "arrow"
                        },
                        "sourceX": 734.5008732069591,
                        "sourceY": 199.80882127097613,
                        "targetX": 567.0588381925,
                        "targetY": 325.61121253831084
                    },
                    {
                        "id": "vueflow__edge-e46b53c3-5854-41ac-bb89-18bb2bfa7141-834bb528-790d-4313-b727-49114c23b6bb",
                        "type": "default",
                        "source": "e46b53c3-5854-41ac-bb89-18bb2bfa7141",
                        "target": "834bb528-790d-4313-b727-49114c23b6bb",
                        "sourceHandle": null,
                        "targetHandle": null,
                        "data": {},
                        "label": "",
                        "style": {
                            "strokeWidth": 1.5
                        },
                        "markerEnd": {
                            "type": "arrow"
                        },
                        "sourceX": 567.0588381925,
                        "sourceY": 384.61126794539575,
                        "targetX": 561.4945623336016,
                        "targetY": 421.48897169387146
                    },
                    {
                        "id": "vueflow__edge-834bb528-790d-4313-b727-49114c23b6bb-fc1e286c-cb54-4395-9617-0e294727f4a4",
                        "type": "default",
                        "source": "834bb528-790d-4313-b727-49114c23b6bb",
                        "target": "fc1e286c-cb54-4395-9617-0e294727f4a4",
                        "sourceHandle": null,
                        "targetHandle": null,
                        "data": {},
                        "label": "",
                        "style": {
                            "strokeWidth": 1.5
                        },
                        "markerEnd": {
                            "type": "arrow"
                        },
                        "sourceX": 561.4945623336016,
                        "sourceY": 480.48895535093965,
                        "targetX": 589.7611172669654,
                        "targetY": 496.7334533827503
                    },
                    {
                        "id": "vueflow__edge-fc1e286c-cb54-4395-9617-0e294727f4a4-764a238b-9d89-41cb-bd72-a6ccf102c6ef",
                        "type": "default",
                        "source": "fc1e286c-cb54-4395-9617-0e294727f4a4",
                        "target": "764a238b-9d89-41cb-bd72-a6ccf102c6ef",
                        "sourceHandle": null,
                        "targetHandle": null,
                        "data": {},
                        "label": "",
                        "style": {
                            "strokeWidth": 1.5
                        },
                        "markerEnd": {
                            "type": "arrow"
                        },
                        "sourceX": 589.7611172669654,
                        "sourceY": 555.7334370398185,
                        "targetX": 615.3188670024559,
                        "targetY": 604.8933863427685
                    }
                ],
                "position": [
                    -27.37685039376356,
                    -13.492477098771303
                ],
                "zoom": 0.8506643208185516,
                "viewport": {
                    "x": -27.37685039376356,
                    "y": -13.492477098771303,
                    "zoom": 0.8506643208185516
                }
            }
            """;
    }