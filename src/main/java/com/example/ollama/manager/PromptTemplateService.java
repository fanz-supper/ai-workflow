package com.example.ollama.manager;

import com.example.ollama.manager.dto.PageDTO;
import com.example.ollama.manager.dto.PromptTemplateDTO;

import java.util.List;

/**
 * @title: PromptService
 * @description:
 * @author: zhangfan
 * @data: 2025年04月27日 01:12
 */
public interface PromptTemplateService {


    PromptTemplateDTO add(PromptTemplateDTO dto);

    void delete(PromptTemplateDTO dto);

    void update(PromptTemplateDTO dto);

    PageDTO<PromptTemplateDTO> queryList(PromptTemplateDTO dto);

    PageDTO<PromptTemplateDTO> queryByName(PromptTemplateDTO dto);

    PromptTemplateDTO queryById(String id);

    List<PromptTemplateDTO> all();
}
