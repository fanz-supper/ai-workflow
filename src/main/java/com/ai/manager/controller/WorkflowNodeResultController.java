package com.ai.manager.controller;

import com.ai.manager.WorkflowNodeResultService;
import com.ai.manager.dto.PageDTO;
import com.ai.manager.dto.ResponseDTO;
import com.ai.manager.dto.WorkflowNodeResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: WorkflowNodeResultController
 * @description:
 * @author: zhangfan
 */
@RestController
@RequestMapping("/flow/nodeResult")
public class WorkflowNodeResultController {

    @Autowired
    private WorkflowNodeResultService workflowNodeResultService;

    @GetMapping("/qid")
    public ResponseDTO<WorkflowNodeResultDTO> queryById(WorkflowNodeResultDTO dto) {
        return ResponseDTO.ok(workflowNodeResultService.queryById(dto));
    }

    @GetMapping("/list")
    public ResponseDTO<PageDTO<WorkflowNodeResultDTO>> queryList(WorkflowNodeResultDTO dto) {
        return ResponseDTO.ok(workflowNodeResultService.queryList(dto));
    }

}
