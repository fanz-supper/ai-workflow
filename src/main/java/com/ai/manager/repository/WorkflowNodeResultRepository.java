package com.ai.manager.repository;

import com.ai.manager.dao.WorkflowNodeResultDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @title: WorkflowNodeResultRepository
 * @description:
 * @author: zhangfan
 * @data: 2025年05月18日 19:34
 */
public interface WorkflowNodeResultRepository extends JpaRepository<WorkflowNodeResultDao, String> {
}
