package com.example.ollama.manager.impl;

import com.example.ollama.manager.Status;
import com.example.ollama.manager.WorkflowResultService;
import com.example.ollama.manager.dao.WorkflowResultDao;
import com.example.ollama.manager.dto.PageDTO;
import com.example.ollama.manager.dto.WorkflowResultDTO;
import com.example.ollama.manager.mapper.PageMapper;
import com.example.ollama.manager.mapper.WorkflowResultMapper;
import com.example.ollama.manager.repository.WorkflowResultRepository;
import com.example.ollama.manager.util.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @title: WorkflowResultServiceImpl
 * @description:
 * @author: zhangfan
 */
@Service
public class WorkflowResultServiceImpl implements WorkflowResultService {

    @Autowired
    private WorkflowResultRepository workflowResultRepository;


    @Override
    public WorkflowResultDTO add(WorkflowResultDTO dto) {

        WorkflowResultDao dao = WorkflowResultMapper.INSTANCE.toDAO(dto);
        dao.setId(ID.primaryId());
        dao.setStatus(Status.NONE.name());
        Date now = new Date();
        dao.setCreateTime(now);
        dao.setUpdateTime(now);

        WorkflowResultDao saved = workflowResultRepository.save(dao);
        return WorkflowResultMapper.INSTANCE.toDTO(saved);
    }

    @Override
    public void delete(WorkflowResultDTO dto) {

    }

    @Override
    public PageDTO<WorkflowResultDTO> queryList(WorkflowResultDTO dto) {

        Page<WorkflowResultDao> all = workflowResultRepository.findAll(dto.pageRequest().withSort(sort()));
        return PageMapper.INSTANCE.toDTO(all, WorkflowResultMapper.INSTANCE::toDTOs);
    }

    @Override
    public WorkflowResultDTO queryById(WorkflowResultDTO dto) {

        WorkflowResultDao dao = workflowResultRepository.findById(dto.getId()).orElseThrow();
        return WorkflowResultMapper.INSTANCE.toDTO(dao);
    }

    private Sort sort() {
        return Sort.by(Sort.Direction.DESC, "createTime");
    }
}
