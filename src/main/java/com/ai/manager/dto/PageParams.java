package com.ai.manager.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

/**
 * @title: PageParams
 * @description:
 * @author: zhangfan
 */
@Getter
@Setter
public class PageParams {

    private Integer pageSize;
    private Integer currentPage;


    public PageRequest pageRequest() {
        return PageRequest.of(currentPage - 1, pageSize);
    }
}
