package com.example.ollama.manager.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * @title: BaseMapper
 * @description:
 * @author: zhangfan
 * @data: 2025年05月13日 12:10
 */

public interface BaseMapper<DTO, DAO> {

    void copyToIgnoreNull(DAO source, @MappingTarget DAO target);

    DTO toDTO(DAO dao);

    List<DTO> toDTOs(List<DAO> daos);

    DAO toDAO(DTO dto);

    List<DAO> toDAOs(List<DTO> dtos);


}
