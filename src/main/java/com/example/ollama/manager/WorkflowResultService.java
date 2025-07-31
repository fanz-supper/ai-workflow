package com.example.ollama.manager;

import com.example.ollama.manager.dto.PageDTO;
import com.example.ollama.manager.dto.WorkflowResultDTO;

/**
 * @title: WorkflowResultService
 * @description:
 * @author: zhangfan
 * @data: 2025年05月18日 19:50
 */
public interface WorkflowResultService {
    WorkflowResultDTO add(WorkflowResultDTO dto);

    void delete(WorkflowResultDTO dto);

    PageDTO<WorkflowResultDTO> queryList(WorkflowResultDTO dto);

    WorkflowResultDTO queryById(WorkflowResultDTO dto);
}
