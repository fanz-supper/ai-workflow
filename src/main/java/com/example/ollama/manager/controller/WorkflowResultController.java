package com.example.ollama.manager.controller;

import com.example.ollama.manager.WorkflowResultService;
import com.example.ollama.manager.dto.PageDTO;
import com.example.ollama.manager.dto.ResponseDTO;
import com.example.ollama.manager.dto.WorkflowResultDTO;
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
