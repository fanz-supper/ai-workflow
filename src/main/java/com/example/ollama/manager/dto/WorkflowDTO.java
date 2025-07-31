package com.example.ollama.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @title: WorkFlowDTO
 * @description:
 * @author: zhangfan
 */
@Getter
@Setter
public class WorkflowDTO extends PageParams {

    private String id;
    private String name;
    private String status;
    private String canvas;
    private Date createTime;
    private Date updateTime;


}
