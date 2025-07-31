package com.ai.manager.controller;

import com.ai.manager.WorkflowResultService;
import com.ai.manager.dto.PageDTO;
import com.ai.manager.dto.ResponseDTO;
import com.ai.manager.dto.WorkflowResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: WorkflowResultController
 * @description:
 * @author: zhangfan
 */
@RestController
@RequestMapping("/flow/result")
public class WorkflowResultController {

    @Autowired
    private WorkflowResultService workflowResultService;

    @GetMapping("/qid")
    public ResponseDTO<WorkflowResultDTO> queryById(WorkflowResultDTO dto) {
        return ResponseDTO.ok(workflowResultService.queryById(dto));
    }

    @GetMapping("/list")
    public ResponseDTO<PageDTO<WorkflowResultDTO>> queryList(WorkflowResultDTO dto) {
        return ResponseDTO.ok(workflowResultService.queryList(dto));
    }

}
