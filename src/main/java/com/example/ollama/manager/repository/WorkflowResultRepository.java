package com.example.ollama.manager.repository;

import com.example.ollama.manager.dao.WorkflowResultDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @title: WorkflowResultRepository
 * @description:
 * @author: zhangfan
 * @data: 2025年05月18日 19:34
 */
public interface WorkflowResultRepository extends JpaRepository<WorkflowResultDao, String> {
}
