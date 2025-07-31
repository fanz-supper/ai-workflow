package com.example.ollama.manager;

import com.example.ollama.manager.dto.ModelDTO;
import com.example.ollama.manager.dto.PageDTO;

import java.util.List;

/**
 * @title: ModelService
 * @description:
 * @author: zhangfan
 * @data: 2025年04月27日 00:49
 */
public interface ModelService {

    ModelDTO add(ModelDTO dto);

    void delete(ModelDTO dto);

    void update(ModelDTO dto);

    PageDTO<ModelDTO> queryList(ModelDTO dto);

    PageDTO<ModelDTO> queryByName(ModelDTO dto);

    List<ModelDTO> all();
}
