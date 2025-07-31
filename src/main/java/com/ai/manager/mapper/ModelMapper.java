package com.ai.manager.mapper;

import com.ai.manager.dao.ModelDao;
import com.ai.manager.dto.ModelDTO;
import com.ai.workflow.metadata.base.ModelInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * @title: ModelMappeer
 * @description:
 * @author: zhangfan
 * @data: 2025年05月13日 11:50
 */
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ModelMapper extends BaseMapper<ModelDTO, ModelDao> {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    @Mapping(source = "dataConverterId", target = "dataConverterKey")
    @Mapping(source = "promptTemplateId", target = "promptTemplateKey")
    @Mapping(source = "type", target = "modelType")
    @Mapping(source = "msg", target = "msg")
    ModelInput toInput(ModelDao dao);

}
