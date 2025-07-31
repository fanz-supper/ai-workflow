package com.example.ollama.manager.mapper;

import com.example.ollama.manager.dao.WorkflowDao;
import com.example.ollama.manager.dto.WorkflowDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * @title: WorkFlowMapper
 * @description:
 * @author: zhangfan
 * @data: 2025年05月13日 11:15
 */
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WorkflowMapper extends BaseMapper<WorkflowDTO, WorkflowDao> {

    WorkflowMapper INSTANCE = Mappers.getMapper(WorkflowMapper.class);
}
