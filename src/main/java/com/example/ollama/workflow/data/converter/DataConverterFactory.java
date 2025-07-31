package com.example.ollama.workflow.data.converter;

import com.example.ollama.workflow.DataConvertEu;
import com.example.ollama.workflow.metadata.DataConverterInput;

/**
 * @title: DataConverterFactory
 * @description:
 * @author: zhangfan
 * @data: 2025年03月14日 01:23
 */
public interface DataConverterFactory {

    DataConvertEu get(DataConverterInput input);
}
