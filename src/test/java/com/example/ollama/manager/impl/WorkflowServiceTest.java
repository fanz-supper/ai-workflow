package com.example.ollama.manager.impl;

import com.example.ollama.manager.WorkflowService;
import com.example.ollama.manager.dto.WorkflowDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @title: WorkflowServiceTest
 * @description:
 * @author: zhangfan
 * @data: 2025年05月20日 15:21
 */
@SpringBootTest
class WorkflowServiceTest {

    @Autowired
    private WorkflowService workflowService;

    @Test
    void run() {

        WorkflowDTO dto = new WorkflowDTO();
        dto.setName("单个模型测试");
        dto.setCanvas(GraphJsonText.str);

        workflowService.run(dto);
    }
}