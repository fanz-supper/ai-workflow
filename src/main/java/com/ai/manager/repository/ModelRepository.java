package com.ai.manager.repository;

import com.ai.manager.dao.ModelDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @title: ModelRepository
 * @description:
 * @author: zhangfan
 * @data: 2025年05月13日 11:05
 */
public interface ModelRepository extends JpaRepository<ModelDao, String> {

    Page<ModelDao> queryByName(String name, Pageable pageable);

    List<ModelDao> queryByIdIn(List<String> ids);

}
