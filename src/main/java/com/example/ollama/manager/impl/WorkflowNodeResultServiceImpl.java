package com.example.ollama.manager.impl;

import com.example.ollama.manager.Status;
import com.example.ollama.manager.WorkflowNodeResultService;
import com.example.ollama.manager.dao.WorkflowNodeResultDao;
import com.example.ollama.manager.dto.PageDTO;
import com.example.ollama.manager.dto.WorkflowNodeResultDTO;
import com.example.ollama.manager.mapper.PageMapper;
import com.example.ollama.manager.mapper.WorkflowNodeResultMapper;
import com.example.ollama.manager.repository.WorkflowNodeResultRepository;
import com.example.ollama.manager.util.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 * @title: WorkflowNodeResultServiceImpl
 * @description:
 * @author: zhangfan
 */
@Service
public class WorkflowNodeResultServiceImpl implements WorkflowNodeResultService {

    @Autowired
    private WorkflowNodeResultRepository workflowNodeResultRepository;

    @Override
    public WorkflowNodeResultDTO add(WorkflowNodeResultDTO dto) {

        WorkflowNodeResultDao dao = WorkflowNodeResultMapper.INSTANCE.toDAO(dto);
        dao.setId(ID.primaryId());
        dao.setStatus(Status.NONE.name());
        Date now = new Date();
        dao.setCreateTime(now);
        dao.setUpdateTime(now);

        WorkflowNodeResultDao saved = workflowNodeResultRepository.save(dao);
        return WorkflowNodeResultMapper.INSTANCE.toDTO(saved);
    }


    @Override
    public void addAll(Collection<WorkflowNodeResultDTO> dtos) {

        Date now = new Date();
        List<WorkflowNodeResultDao> daos = dtos.stream()
                .map(dto -> {
                    WorkflowNodeResultDao dao = WorkflowNodeResultMapper.INSTANCE.toDAO(dto);
                    dao.setId(ID.primaryId());
                    dao.setStatus(Status.NONE.name());
                    dao.setCreateTime(now);
                    dao.setUpdateTime(now);
                    return dao;
                })
                .toList();

        workflowNodeResultRepository.saveAll(daos);
    }

    @Override
    public void delete(WorkflowNodeResultDTO dto) {

    }

    @Override
    public PageDTO<WorkflowNodeResultDTO> queryList(WorkflowNodeResultDTO dto) {

        Page<WorkflowNodeResultDao> all = workflowNodeResultRepository.findAll(dto.pageRequest().withSort(sort()));
        return PageMapper.INSTANCE.toDTO(all, WorkflowNodeResultMapper.INSTANCE::toDTOs);
    }


    @Override
    public WorkflowNodeResultDTO queryById(WorkflowNodeResultDTO dto) {

        WorkflowNodeResultDao dao = workflowNodeResultRepository.findById(dto.getId()).orElseThrow();
        return WorkflowNodeResultMapper.INSTANCE.toDTO(dao);
    }

    private Sort sort() {
        return Sort.by(Sort.Direction.DESC, "createTime");
    }
}
