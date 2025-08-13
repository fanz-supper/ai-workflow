# workflow

#### 介绍

本Workflow项目是一套集成化、自动化的软件开发流程辅助系统，旨在通过模块化、组件化的方式，高效处理从项目描述输入到最终代码文件生成的一系列任务。

系统基于多个功能各异的执行单元（EU）构建，涵盖从文本处理、模型调用到文件操作等不同环节。用户输入项目描述后，系统先利用Prompt EU和Model EU对其进行优化处理，提炼关键信息。随后，在设计方案与分区模块阶段，通过特定EU组合生成yaml文件，清晰定义项目结构与配置。

在领域模型构建方面，借助For EU等组件遍历相关元数据，生成包括目录结构的yaml，为项目搭建基础架构。之后，系统进一步生成Java类，期间各EU协同工作，确保代码结构与业务逻辑准确实现。最后，FileWriter EU将生成的代码写入指定文件，完成整个项目开发流程的自动化构建。

该项目通过标准化、流程化的方式，减少人工干预，提升软件开发效率与代码质量，尤其适用于需要快速迭代和高效开发的项目场景。 
![输入图片说明](https://foruda.gitee.com/images/1747122739730134125/6007815e_15822687.png "屏幕截图")


#### EU-Based Architecture Overview
The system implements a sophisticated Execution Unit (EU) architecture where each EU represents a specialized processing component within the larger workflow graph. This design enables dynamic composition of processing pipelines based on workflow requirements.

Core EU Component System

<img width="1574" height="560" alt="image" src="https://github.com/user-attachments/assets/588a682a-3c18-4ab5-918c-9a4d09466709" />

The ModelEuFactory serves as the central orchestration component, coordinating between different EU types and managing the overall workflow execution pipeline. Each EU maintains specific responsibilities within the processing chain, enabling fine-grained control over individual workflow steps.

Sources: Based on system architecture diagrams provided in context


#### Code Generation Workflow Pipeline
The system processes project descriptions through a standardized pipeline that transforms natural language requirements into structured code outputs through multiple processing stages.

#### Processing Pipeline Flow
<img width="711" height="857" alt="image" src="https://github.com/user-attachments/assets/5922d07b-10f8-4503-b8eb-0d626c189a8b" />

Each stage maintains discrete responsibilities while enabling seamless data flow between components. The ProcessorAssembler dynamically constructs the execution graph based on workflow requirements, allowing for flexible pipeline configuration.

#### Modular Component Design
The system implements a highly modular design where components can be independently developed, tested, and deployed. This architecture supports extensibility and maintainability through clear separation of concerns.

<img width="680" height="531" alt="image" src="https://github.com/user-attachments/assets/0e3c64be-d4f7-4cf5-a6e8-d0b1f036af2e" />


> 项目详情 https://deepwiki.com/fanz-supper/ai-workflow/1.1-system-purpose-and-design
