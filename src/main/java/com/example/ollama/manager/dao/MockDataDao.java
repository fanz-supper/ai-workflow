package com.example.ollama.manager.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "mock_data")
@Getter
@Setter
public class MockDataDao {

    @Id
    private String id;

    private String name;

    private String status;

    private String type;

    private String data;

    private String componentIds;
    private Date createTime;
    private Date updateTime;
}