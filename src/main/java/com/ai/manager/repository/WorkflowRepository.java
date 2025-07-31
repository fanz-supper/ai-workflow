package com.ai.manager.repository;

import com.ai.manager.dao.WorkflowDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @title: WorkflowRepository
 * @description:
 * @author: zhangfan
 * @data: 2025年05月13日 11:06
 */
public interface WorkflowRepository extends JpaRepository<WorkflowDao, String> {

    Page<WorkflowDao> queryByName(String name, Pageable pageable);
}
