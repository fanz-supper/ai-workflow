package com.example.ollama.manager.controller;

import com.example.ollama.manager.PromptTemplateService;
import com.example.ollama.manager.dto.PageDTO;
import com.example.ollama.manager.dto.PromptTemplateDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @title: PromptTemplateControllerTest
 * @description:
 * @author: zhangfan
 * @data: 2025年05月13日 19:47
 */
@SpringBootTest
class PromptTemplateControllerTest {

    @Autowired
    private PromptTemplateService promptTemplateService;

    @Test
    void add() {

        for (int i = 100; i < 200; i++) {

            PromptTemplateDTO dto = new PromptTemplateDTO();

            dto.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            dto.setName("提示模板" + i);
            dto.setStatus("INIT");
            dto.setTemplate("你好${msg}" + i);

            Date now = new Date();
            dto.setCreateTime(now);
            dto.setUpdateTime(now);

            promptTemplateService.add(dto);
        }
    }

    @Test
    void queryByName() {
    }

    @Test
    void queryAll() {

        PromptTemplateDTO dto = new PromptTemplateDTO();
        dto.setCurrentPage(1);
        dto.setPageSize(10);

        PageDTO<PromptTemplateDTO> promptTemplateDTOPageDTO = promptTemplateService.queryList(dto);
    }
}