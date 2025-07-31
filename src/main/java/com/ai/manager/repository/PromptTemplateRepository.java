package com.ai.manager.repository;

import com.ai.manager.dao.PromptTemplateDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @title: PromptTemplateRepository
 * @description:
 * @author: zhangfan
 * @data: 2025年05月13日 11:06
 */
public interface PromptTemplateRepository extends JpaRepository<PromptTemplateDao, String> {

    Page<PromptTemplateDao> queryByName(String name, Pageable pageable);

    PromptTemplateDao queryByName(String name);
}
