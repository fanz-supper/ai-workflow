package com.ai.manager.mapper;

import com.ai.manager.dto.PageDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

/**
 * @title: PageMapper
 * @description:
 * @author: zhangfan
 * @data: 2025年05月13日 11:37
 */
public interface PageMapper {

    PageMapper INSTANCE = new PageMapper() {
    };

    default <DTO, DAO> PageDTO<DTO> toDTO(Page<DAO> page, Function<List<DAO>, List<DTO>> convertList) {

        PageDTO<DTO> dto = new PageDTO<>();
        dto.setList(convertList.apply(page.toList()));
        dto.setCurrentPage(page.getNumber());
        dto.setTotal((int) page.getTotalElements());

        return dto;
    }

}
