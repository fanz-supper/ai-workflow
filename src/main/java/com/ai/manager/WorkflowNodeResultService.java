package com.ai.manager;

import com.ai.manager.dto.PageDTO;
import com.ai.manager.dto.WorkflowNodeResultDTO;

import java.util.Collection;

/**
 * @title: WorkflowNodeResultService
 * @description:
 * @author: zhangfan
 * @data: 2025年05月18日 19:57
 */
public interface WorkflowNodeResultService {
    WorkflowNodeResultDTO add(WorkflowNodeResultDTO dto);

    void addAll(Collection<WorkflowNodeResultDTO> dtos);

    void delete(WorkflowNodeResultDTO dto);

    PageDTO<WorkflowNodeResultDTO> queryList(WorkflowNodeResultDTO dto);

    WorkflowNodeResultDTO queryById(WorkflowNodeResultDTO dto);
}
