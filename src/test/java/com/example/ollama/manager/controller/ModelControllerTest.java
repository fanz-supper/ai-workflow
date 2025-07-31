package com.example.ollama.manager.controller;

import com.example.ollama.manager.ModelService;
import com.example.ollama.manager.dto.ModelDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

/**
 * @title: ModelControllerTest
 * @description:
 * @author: zhangfan
 * @data: 2025年05月13日 17:08
 */
@SpringBootTest
class ModelControllerTest {

    @Autowired
    private ModelService modelService;

    @Test
    void add() {

        for (int i = 100; i < 200; i++) {

            ModelDTO dto = new ModelDTO();

            dto.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            dto.setName("ChatGPT3.0." + i);
            dto.setType("ChatGPT3.0");
            dto.setStatus("INIT");
            dto.setPromptTemplateId("pt000" + i);
            dto.setDataConverterId("dc0000" + i);

            Date now = new Date();

            dto.setCreateTime(now);
            dto.setUpdateTime(now);
            modelService.add(dto);
        }

    }

    @Test
    void queryByName() {
    }

    @Test
    void queryList() {
    }
}