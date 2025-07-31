package com.example.ollama.manager;

import com.example.ollama.manager.dto.MockDataDTO;
import com.example.ollama.manager.dto.PageDTO;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * @title: ModelService
 * @description:
 * @author: zhangfan
 * @data: 2025年04月27日 00:49
 */
public interface MockDataService {

    MockDataDTO add(MockDataDTO dto);

    void delete(MockDataDTO dto);

    void update(MockDataDTO dto);

    PageDTO<MockDataDTO> queryList(MockDataDTO dto);

    PageDTO<MockDataDTO> queryByName(MockDataDTO dto);

    List<MockDataDTO> all();

    @Async
    void run(MockDataDTO dto);
}
