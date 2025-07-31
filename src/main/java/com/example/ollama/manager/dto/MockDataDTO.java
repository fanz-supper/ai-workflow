package com.example.ollama.manager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MockDataDTO extends PageParams {

    private String id;
    private String name;
    private String status;
    private String type;
    private String data;
    private List<String> componentIds;
    private Date createTime;
    private Date updateTime;
}