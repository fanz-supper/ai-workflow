package com.example.ollama.manager.mapper;

import com.example.ollama.manager.dao.WorkflowNodeResultDao;
import com.example.ollama.manager.dto.WorkflowNodeResultDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

/**
 * @title: WorkflowNodeResultMapper
 * @description:
 * @author: zhangfan
 * @data: 2025年05月18日 19:33
 */
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WorkflowNodeResultMapper extends BaseMapper<WorkflowNodeResultDTO, WorkflowNodeResultDao> {

    WorkflowNodeResultMapper INSTANCE = Mappers.getMapper(WorkflowNodeResultMapper.class);
}
