package com.ai.manager.impl;

import com.ai.manager.PromptTemplateService;
import com.ai.manager.Status;
import com.ai.manager.dao.PromptTemplateDao;
import com.ai.manager.dto.PageDTO;
import com.ai.manager.dto.PromptTemplateDTO;
import com.ai.manager.mapper.PageMapper;
import com.ai.manager.mapper.PromptTemplateMapper;
import com.ai.manager.repository.PromptTemplateRepository;
import com.ai.manager.util.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @title: PromptTemplateServiceImpl
 * @description:
 * @author: zhangfan
 */
@Service
public class PromptTemplateServiceImpl implements PromptTemplateService {

    @Autowired
    private PromptTemplateRepository promptTemplateRepository;

    @Override
    public PromptTemplateDTO add(PromptTemplateDTO dto) {

        PromptTemplateDao dao = PromptTemplateMapper.INSTANCE.toDAO(dto);
        dao.setId(ID.primaryId());
        dao.setStatus(Status.NONE.name());
        Date now = new Date();
        dao.setCreateTime(now);
        dao.setUpdateTime(now);

        PromptTemplateDao saved = promptTemplateRepository.save(dao);
        return PromptTemplateMapper.INSTANCE.toDTO(saved);
    }

    @Override
    public void delete(PromptTemplateDTO dto) {

    }

    @Override
    public void update(PromptTemplateDTO dto) {

        promptTemplateRepository.findById(dto.getId())
                .ifPresent(update -> {

                    PromptTemplateDao dao = PromptTemplateMapper.INSTANCE.toDAO(dto);
                    PromptTemplateMapper.INSTANCE.copyToIgnoreNull(dao, update);

                    update.setUpdateTime(new Date());
                    promptTemplateRepository.save(update);
                });
    }

    @Override
    public PageDTO<PromptTemplateDTO> queryList(PromptTemplateDTO dto) {

        Page<PromptTemplateDao> page = promptTemplateRepository.findAll(dto.pageRequest().withSort(sort()));
        return PageMapper.INSTANCE.toDTO(page, PromptTemplateMapper.INSTANCE::toDTOs);
    }

    @Override
    public PageDTO<PromptTemplateDTO> queryByName(PromptTemplateDTO dto) {

        Page<PromptTemplateDao> page = promptTemplateRepository.queryByName(dto.getName(), dto.pageRequest().withSort(sort()));
        return PageMapper.INSTANCE.toDTO(page, PromptTemplateMapper.INSTANCE::toDTOs);
    }

    @Override
    public PromptTemplateDTO queryById(String id) {
        return PromptTemplateMapper.INSTANCE.toDTO(promptTemplateRepository.findById(id).orElseThrow());
    }

    @Override
    public List<PromptTemplateDTO> all() {
        return PromptTemplateMapper.INSTANCE.toDTOs(promptTemplateRepository.findAll(sort()));
    }


    private Sort sort() {
        return Sort.by(Sort.Direction.DESC, "createTime");
    }
}
