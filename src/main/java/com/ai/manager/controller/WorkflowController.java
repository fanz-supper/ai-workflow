package com.ai.manager.controller;

import com.ai.manager.WorkflowService;
import com.ai.manager.dto.PageDTO;
import com.ai.manager.dto.ResponseDTO;
import com.ai.manager.dto.WorkflowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @title: WorkflowController
 * @description:
 * @author: zhangfan
 */
@RestController
@RequestMapping("/flow")
public class WorkflowController {

    @Autowired
    private WorkflowService workFlowService;

    @PostMapping("/add")
    public ResponseDTO<WorkflowDTO> add(@RequestBody WorkflowDTO dto) {
        return ResponseDTO.ok(workFlowService.add(dto));
    }

    @PostMapping("/update")
    public ResponseDTO<Void> update(@RequestBody WorkflowDTO dto) {
        workFlowService.update(dto);
        return ResponseDTO.ok();
    }

    @GetMapping("/qname")
    public ResponseDTO<PageDTO<WorkflowDTO>> queryByName(WorkflowDTO dto) {
        return ResponseDTO.ok(workFlowService.queryByName(dto));
    }

    @GetMapping("/qid")
    public ResponseDTO<WorkflowDTO> queryById(WorkflowDTO dto) {
        return ResponseDTO.ok(workFlowService.queryById(dto));
    }

    @GetMapping("/list")
    public ResponseDTO<PageDTO<WorkflowDTO>> queryList(WorkflowDTO dto) {
        return ResponseDTO.ok(workFlowService.queryList(dto));
    }

    @PostMapping("/run")
    public ResponseDTO<Void> run(@RequestBody WorkflowDTO dto) {
        workFlowService.run(dto);
        return ResponseDTO.ok();
    }

}
