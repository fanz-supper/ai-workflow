package com.ai.manager.mapper;

import com.ai.manager.dao.WorkflowNodeResultDao;
import com.ai.manager.dto.WorkflowNodeResultDTO;
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
