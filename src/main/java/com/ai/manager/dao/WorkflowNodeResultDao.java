package com.ai.manager.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "workflow_node_result")
@Getter
@Setter
public class WorkflowNodeResultDao {

    @Id
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
