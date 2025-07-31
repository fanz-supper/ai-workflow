package com.example.ollama.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @title: Page
 * @description:
 * @author: zhangfan
 */
@Getter
@Setter
public class PageDTO<T> {

    private List<T> list;
    private int pageSize;
    private int currentPage;
    private int total;

}
