package com.example.ollama.manager.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "mock_result")
@Getter
@Setter
public class MockResultDao {

    @Id
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