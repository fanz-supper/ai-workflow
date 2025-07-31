package com.example.ollama.manager.impl;

import com.example.ollama.manager.MockDataService;
import com.example.ollama.manager.dto.MockDataDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @title: MockDataServiceImplTest
 * @description:
 * @author: zhangfan
 * @data: 2025年05月17日 15:08
 */
@SpringBootTest
class MockDataServiceImplTest {

    @Autowired
    private MockDataService mockDataService;

    @Test
    void run() {

        MockDataDTO dto = new MockDataDTO();
        dto.setId("7421df77304741b6bb3e596408edd9d8");
        dto.setType("CHAT");
        dto.setComponentIds(List.of("21bddc8ed3e445bf8d7dec6204192a9d"));
        dto.setData("图书管理系统");
        mockDataService.run(dto);

    }
}