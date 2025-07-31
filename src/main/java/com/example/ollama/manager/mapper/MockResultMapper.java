package com.example.ollama.manager.mapper;

import com.example.ollama.manager.dao.MockResultDao;
import com.example.ollama.manager.dto.MockResultDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * @title: MockResultMapper
 * @description:
 * @author: zhangfan
 * @data: 2025年05月15日 20:42
 */
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MockResultMapper extends BaseMapper<MockResultDTO, MockResultDao> {
    MockResultMapper INSTANCE = Mappers.getMapper(MockResultMapper.class);
}
