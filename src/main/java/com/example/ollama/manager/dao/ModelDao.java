package com.example.ollama.manager.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

/**
 * @title: ModelDao
 * @description:
 * @author: zhangfan
 */

@Getter
@Setter

@Entity
@Table(name = "model")
@DynamicUpdate
public class ModelDao {

    @Id
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
