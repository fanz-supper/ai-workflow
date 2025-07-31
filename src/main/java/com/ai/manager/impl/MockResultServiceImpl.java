package com.ai.manager.impl;

import com.ai.manager.MockResultService;
import com.ai.manager.Status;
import com.ai.manager.dao.MockResultDao;
import com.ai.manager.dto.MockResultDTO;
import com.ai.manager.dto.PageDTO;
import com.ai.manager.mapper.MockResultMapper;
import com.ai.manager.mapper.PageMapper;
import com.ai.manager.repository.MockResultRepository;
import com.ai.manager.util.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @title: MockResultServiceImpl
 * @description:
 * @author: zhangfan
 */
@Service
public class MockResultServiceImpl implements MockResultService {

    @Autowired
    private MockResultRepository mockResultRepository;

    @Override
    public MockResultDTO add(MockResultDTO dto) {

        MockResultDao dao = MockResultMapper.INSTANCE.toDAO(dto);
        dao.setId(ID.primaryId());
        dao.setStatus(Status.NONE.name());
        Date now = new Date();
        dao.setCreateTime(now);
        dao.setUpdateTime(now);

        MockResultDao saved = mockResultRepository.save(dao);
        return MockResultMapper.INSTANCE.toDTO(saved);
    }

    @Override
    public void delete(MockResultDTO dto) {

    }

    @Override
    public void update(MockResultDTO dto) {

        mockResultRepository.findById(dto.getId())
                .ifPresent(update -> {

                    MockResultDao dao = MockResultMapper.INSTANCE.toDAO(dto);
                    MockResultMapper.INSTANCE.copyToIgnoreNull(dao, update);

                    update.setUpdateTime(new Date());
                    mockResultRepository.save(update);
                });
    }

    @Override
    public PageDTO<MockResultDTO> queryList(MockResultDTO dto) {

        Page<MockResultDao> page = mockResultRepository.findAll(dto.pageRequest().withSort(sort()));
        return PageMapper.INSTANCE.toDTO(page, MockResultMapper.INSTANCE::toDTOs);
    }

    @Override
    public List<MockResultDTO> all() {
        return MockResultMapper.INSTANCE.toDTOs(mockResultRepository.findAll(sort()));
    }

    private Sort sort() {
        return Sort.by(Sort.Direction.DESC, "createTime");
    }

}
