package com.ai.manager.repository;

import com.ai.manager.dao.MockResultDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @title: ModelRepository
 * @description:
 * @author: zhangfan
 * @data: 2025年05月13日 11:05
 */
public interface MockResultRepository extends JpaRepository<MockResultDao, String> {

}
