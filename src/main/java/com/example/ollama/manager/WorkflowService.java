package com.example.ollama.manager;

import com.example.ollama.manager.dto.PageDTO;
import com.example.ollama.manager.dto.WorkflowDTO;

/**
 * @title: WorkFlowService
 * @description:
 * @author: zhangfan
 * @data: 2025年04月27日 01:13
 */
public interface WorkflowService {
    WorkflowDTO add(WorkflowDTO dto);

    void delete(WorkflowDTO dto);

    void update(WorkflowDTO dto);

    PageDTO<WorkflowDTO> queryList(WorkflowDTO dto);

    PageDTO<WorkflowDTO> queryByName(WorkflowDTO dto);

    WorkflowDTO queryById(WorkflowDTO dto);

    void run(WorkflowDTO dto);
}
