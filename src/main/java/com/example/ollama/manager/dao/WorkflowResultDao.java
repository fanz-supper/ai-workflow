package com.example.ollama.manager.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "workflow_result")
@Getter
@Setter
public class WorkflowResultDao {

    @Id
    private String id;

    private String workflowId;

    private String groupId;

    private String name;

    private String status;

    private String canvas;

    private Date createTime;

    private Date updateTime;
}