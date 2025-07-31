package com.ai.manager.impl;

import com.ai.manager.ModelService;
import com.ai.manager.Status;
import com.ai.manager.dao.ModelDao;
import com.ai.manager.dto.ModelDTO;
import com.ai.manager.dto.PageDTO;
import com.ai.manager.mapper.ModelMapper;
import com.ai.manager.mapper.PageMapper;
import com.ai.manager.repository.ModelRepository;
import com.ai.manager.util.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @title: ModelServiceImpl
 * @description:
 * @author: zhangfan
 */
@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public ModelDTO add(ModelDTO dto) {

        ModelDao dao = ModelMapper.INSTANCE.toDAO(dto);
        dao.setId(ID.primaryId());
        dao.setStatus(Status.NONE.name());
        Date now = new Date();
        dao.setCreateTime(now);
        dao.setUpdateTime(now);

        ModelDao saved = modelRepository.save(dao);
        return ModelMapper.INSTANCE.toDTO(saved);
    }

    @Override
    public void delete(ModelDTO dto) {

    }

    @Override
    public void update(ModelDTO dto) {

        modelRepository.findById(dto.getId())
                .ifPresent(update -> {

                    ModelDao dao = ModelMapper.INSTANCE.toDAO(dto);
                    ModelMapper.INSTANCE.copyToIgnoreNull(dao, update);

                    update.setUpdateTime(new Date());
                    modelRepository.save(update);
                });
    }

    @Override
    public PageDTO<ModelDTO> queryList(ModelDTO dto) {

        Page<ModelDao> page = modelRepository.findAll(dto.pageRequest().withSort(sort()));
        return PageMapper.INSTANCE.toDTO(page, ModelMapper.INSTANCE::toDTOs);
    }

    @Override
    public PageDTO<ModelDTO> queryByName(ModelDTO dto) {

        Page<ModelDao> page = modelRepository.queryByName(dto.getName(), dto.pageRequest().withSort(sort()));
        return PageMapper.INSTANCE.toDTO(page, ModelMapper.INSTANCE::toDTOs);
    }

    @Override
    public List<ModelDTO> all() {
        return ModelMapper.INSTANCE.toDTOs(modelRepository.findAll(sort()));
    }

    private Sort sort() {
        return Sort.by(Sort.Direction.DESC, "createTime");
    }
}
