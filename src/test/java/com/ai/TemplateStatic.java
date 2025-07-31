package com.ai;

import java.util.Map;

/**
 * @title: TemplateStatis
 * @description:
 * @author: zhangfan
 * @data: 2025年03月17日 18:40
 */
public interface TemplateStatic {


    String des = """
            项目描述：图书馆管理系统
            1. 项目目标
            图书馆管理系统旨在提供一个易于使用、高效且集中化的解决方案，用于管理图书馆的书籍、用户和借阅记录。系统将简化图书馆的日常操作，提高管理效率，提升用户体验。
            
            2. 主要功能模块
            书籍管理:
            
            添加、更新和删除书籍记录
            查看书籍的详细信息（包括ISBN、作者、出版日期等）
            支持书籍的分类和标签
            用户管理:
            
            用户注册与登录
            更新用户信息（如地址、联系方式等）
            管理用户的权限等级（管理员、普通用户）
            借阅管理:
            
            记录书籍的借阅和归还
            设定借阅期限，并自动提醒用户
            处理逾期未还的书籍，生成逾期罚款记录
            搜索与查询:
            
            提供书籍搜索功能（按标题、作者、ISBN等）
            显示书籍的借阅状态（可借、已借）
            统计与报告:
            
            生成各类统计报表，例如借阅频率、用户登记情况等
            评估图书馆的书籍流通情况和用户活跃度
            系统设置:
            
            管理系统的基本设定（如借阅规则、罚款金额等）
            定义管理员账号与权限
            """;


    String t1 = """
                template is "
            modules:
              - name: ${ModuleName}
                functionality: ${FunctionalityMessage}
                features:
                  - ${features[0]}
                  - ${features[1]}
            "
            Refer to this template and generate partial modules. Only return the YAML file. 
            System description is :
            ${msg}
            """;

    String t2 = """
            "Generate a YAML configuration for the <领域名称> system using the provided template. The entity should be <核心实体> with the following specifications:
            
            1 Fields:
            Define the fields for <核心实体> including essential attributes such as id, createTime, updateTime, and other domain-specific fields.
            Each field should have type, length, constraints (e.g., required, unique), and a meaningful comment. example template :\s
            "
            domain:
              name: User
              fields:
                - name: id
                  type: Long
                  primary: true
                  generateStrategy: auto
                - name: username
                  type: String
                  length: 50
                  unique: true
                  required: true
                  comment: "用户登录名"
            "
            
            2 DTO:
            Define multiple DTOs, such as <核心实体>CreateDTO, <核心实体>UpdateDTO, and other relevant ones (e.g., LoginRequestDTO).
            Include field mappings for the entity's attributes with proper descriptions. not need length proper. example template :  \s
            "
              dto:
                - name: UserCreateDTO
                  fields:
                    - name: username
                      type: String
                      unique: true
                      required: true
            "
            
            3 Repository:
            Create a repository interface, such as <核心实体>Repository, with methods like save, findById, findAll, and custom queries (e.g., findByName).
            Each method should have clear descriptions and parameter definitions. example template :\s
            "
              repository:
                name: UserRepository
                methods:
                  - name: save
                    description: "保存用户信息"
            "
            
            4 Service:
            Define a service interface, such as <核心实体>Service, with methods for creating, updating, deleting, and retrieving entities.
            Include custom logic as necessary (e.g., business-specific operations). example template :\s
            "
              service:
                name: UserService
                methods:
                  - name: createUser
                    parameters:
                      - name: userCreateDTO
                        type: UserCreateDTO
                    description: "创建新用户"
            "
            
            5 Controller:
            Create a REST controller, such as <核心实体>Controller, with endpoints for CRUD operations.
            Specify HTTP methods, paths, request bodies, and functionality descriptions. example template :\s
            "
              controller:
                name: UserController
                endpoints:
                  - method: POST
                    path: /users
                    description: "创建新用户"
                    requestBody:
                      type: UserCreateDTO
            "
            
            6 Converter:
            Define a converter class, such as <核心实体>Mapper, for mapping between DTOs and the entity.
            Specify transformation logic, ignored fields, and additional mappings for fields like createTime and updateTime. example template:
            "
              converter:
                name: UserMapper
                description: "转换器用于将 UserCreateDTO, UserUpdateDTO 和 User 实体类之间进行转换"
                mappings:
                  - from: UserCreateDTO
                    to: User
                    description: "将 UserCreateDTO 转换为 User 实体类"
                    ignoreFields:
                      - id
                      - createTime
                      - updateTime
                    additionalMappings:
                      - field: createTime
                        expression: "new java.sql.Timestamp(System.currentTimeMillis())"
                      - field: updateTime
                        expression: "new java.sql.Timestamp(System.currentTimeMillis())"
            "
            Refer to this template. generate '${msg}' domain template. only return yaml file
            """;

    String t3 = """
            ${msg}
            Generate a Spring Boot ServiceImpl.java file.
            Return only the Java file content without any explanation or additional information.
            """;
    String t4 = """
            ${msg}
            Generate a Spring Boot Controller.java file.
            Return only the Java file content without any explanation or additional information.
            """;
    Map<String, String> tMap = Map.of(
            "PartialModules", t1,
            "DomainInfo", t2,
            "ServiceImpl", t3,
            "Controller", t4
    );
}
