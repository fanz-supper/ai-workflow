package com.example.ollama.manager.repository;

import com.example.ollama.manager.dao.MockDataDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @title: ModelRepository
 * @description:
 * @author: zhangfan
 * @data: 2025年05月13日 11:05
 */
public interface MockDataRepository extends JpaRepository<MockDataDao, String> {

    Page<MockDataDao> queryByName(String name, Pageable pageable);

}
