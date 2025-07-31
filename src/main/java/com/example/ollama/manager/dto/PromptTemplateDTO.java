package com.example.ollama.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @title: PromptTemplateDTO
 * @description:
 * @author: zhangfan
 */
@Getter
@Setter
public class PromptTemplateDTO extends PageParams {

    private String id;
    private String name;
    private String status;
    private String template;
    private Date createTime;
    private Date updateTime;

}
