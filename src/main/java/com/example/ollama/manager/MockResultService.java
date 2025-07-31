package com.example.ollama.manager;

import com.example.ollama.manager.dto.MockResultDTO;
import com.example.ollama.manager.dto.PageDTO;

import java.util.List;

/**
 * @title: ModelService
 * @description:
 * @author: zhangfan
 * @data: 2025年04月27日 00:49
 */
public interface MockResultService {

    MockResultDTO add(MockResultDTO dto);

    void delete(MockResultDTO dto);

    void update(MockResultDTO dto);

    PageDTO<MockResultDTO> queryList(MockResultDTO dto);

    List<MockResultDTO> all();
}
