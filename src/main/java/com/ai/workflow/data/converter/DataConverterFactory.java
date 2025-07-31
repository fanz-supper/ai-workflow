package com.ai.workflow.data.converter;

import com.ai.workflow.DataConvertEu;
import com.ai.workflow.metadata.DataConverterInput;

/**
 * @title: DataConverterFactory
 * @description:
 * @author: zhangfan
 * @data: 2025年03月14日 01:23
 */
public interface DataConverterFactory {

    DataConvertEu get(DataConverterInput input);
}
