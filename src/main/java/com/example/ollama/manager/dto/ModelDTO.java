package com.example.ollama.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @title: ModelDTO
 * @description:
 * @author: zhangfan
 */
@Getter
@Setter
public class ModelDTO extends PageParams {

    private String id;
    private String name;
    private String type;
    private String status;
    private String msg;
    private String promptTemplateId;
    private String dataConverterId;
    private Date createTime;
    private Date updateTime;

}
