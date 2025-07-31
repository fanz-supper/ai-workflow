package com.ai.manager.impl;

import com.ai.manager.WorkflowService;
import com.ai.manager.dto.WorkflowDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
