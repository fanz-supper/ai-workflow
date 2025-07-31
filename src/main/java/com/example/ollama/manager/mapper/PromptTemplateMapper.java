package com.example.ollama.manager.mapper;

import com.example.ollama.manager.dao.PromptTemplateDao;
import com.example.ollama.manager.dto.PromptTemplateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * @title: PromptTemplateMapper
 * @description:
 * @author: zhangfan
 * @data: 2025年05月13日 11:48
 */
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PromptTemplateMapper extends BaseMapper<PromptTemplateDTO, PromptTemplateDao> {

    PromptTemplateMapper INSTANCE = Mappers.getMapper(PromptTemplateMapper.class);

}
