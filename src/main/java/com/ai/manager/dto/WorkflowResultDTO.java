package com.ai.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class WorkflowResultDTO extends PageParams {

    private String id;

    private String workflowId;

    private String groupId;

    private String name;

    private String status;

    private String canvas;

    private Date createTime;

    private Date updateTime;
}
