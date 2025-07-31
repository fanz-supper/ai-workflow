package com.example.ollama.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WorkflowNodeResultDTO extends PageParams {

    private String id;

    private String nodeId;

    private String resultId;

    private String name;

    private String serviceType;

    private String status;

    private String input;

    private String output;

    private Date createTime;

    private Date updateTime;
}