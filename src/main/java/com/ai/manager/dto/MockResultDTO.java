package com.ai.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MockResultDTO extends PageParams {

    private String id;

    private String groupId;


    private String dataId;

    private String status;

    private String type;

    private String data;

    private String componentId;

    private String result;

    private Date createTime;

    private Date updateTime;
}
