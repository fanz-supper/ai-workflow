package com.example.ollama.manager;

import com.example.ollama.manager.dto.DataConverterDTO;
import com.example.ollama.manager.dto.PageDTO;

/**
 * @title: DataConverterService
 * @description:
 * @author: zhangfan
 * @data: 2025年04月27日 01:39
 */
public interface DataConverterService {
    PageDTO<DataConverterDTO> queryPage(DataConverterDTO cmd);
}
