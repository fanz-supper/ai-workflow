package com.ai.manager.mapper;

import com.ai.manager.dao.MockDataDao;
import com.ai.manager.dto.MockDataDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @title: MockDataMapper
 * @description:
 * @author: zhangfan
 */
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MockDataMapper extends BaseMapper<MockDataDTO, MockDataDao> {
    MockDataMapper INSTANCE = Mappers.getMapper(MockDataMapper.class);


    @Mapping(source = "componentIds", target = "componentIds", qualifiedByName = "toList")
    @Override
    MockDataDTO toDTO(MockDataDao mockDataDao);

    @Mapping(source = "componentIds", target = "componentIds", qualifiedByName = "toLine")
    @Override
    MockDataDao toDAO(MockDataDTO mockDataDTO);

    @Named("toLine")
    default String toLine(List<String> list) {
        if (CollectionUtils.isEmpty(list)) {
            return "";
        }
        return list.stream().collect(Collectors.joining(","));
    }

    @Named("toList")
    default List<String> toList(String line) {

        if (!StringUtils.hasText(line)) {
            return List.of();
        }

        return Arrays.asList(line.split(","));
    }
}
