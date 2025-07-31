package com.ai.manager.impl;

import com.ai.manager.MockDataService;
import com.ai.manager.MockResultService;
import com.ai.manager.Status;
import com.ai.manager.dao.MockDataDao;
import com.ai.manager.dao.ModelDao;
import com.ai.manager.dto.MockDataDTO;
import com.ai.manager.dto.MockResultDTO;
import com.ai.manager.dto.PageDTO;
import com.ai.manager.mapper.MockDataMapper;
import com.ai.manager.mapper.ModelMapper;
import com.ai.manager.mapper.PageMapper;
import com.ai.manager.repository.MockDataRepository;
import com.ai.manager.repository.ModelRepository;
import com.ai.manager.util.ID;
import com.ai.workflow.ModelEu;
import com.ai.workflow.metadata.Output;
import com.ai.workflow.metadata.base.ModelInput;
import com.ai.workflow.model.ModelEuFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @title: MockDataServiceImpl
 * @description:
 * @author: zhangfan
 */
@Service
public class MockDataServiceImpl implements MockDataService {

    @Autowired
    private MockDataRepository mockDataRepository;
    @Autowired
    private MockResultService mockResultService;
    @Autowired
    private ModelEuFactory modelEuFactory;
    @Autowired
    private ModelRepository modelRepository;

    @Override
    public MockDataDTO add(MockDataDTO dto) {

        MockDataDao dao = MockDataMapper.INSTANCE.toDAO(dto);
        dao.setId(ID.primaryId());
        dao.setStatus(Status.NONE.name());
        Date now = new Date();
        dao.setCreateTime(now);
        dao.setUpdateTime(now);

        MockDataDao saved = mockDataRepository.save(dao);
        return MockDataMapper.INSTANCE.toDTO(saved);
    }

    @Override
    public void delete(MockDataDTO dto) {

    }

    @Override
    public void update(MockDataDTO dto) {

        mockDataRepository.findById(dto.getId())
                .ifPresent(update -> {

                    MockDataDao dao = MockDataMapper.INSTANCE.toDAO(dto);
                    MockDataMapper.INSTANCE.copyToIgnoreNull(dao, update);

                    update.setUpdateTime(new Date());
                    mockDataRepository.save(update);
                });
    }

    @Override
    public PageDTO<MockDataDTO> queryList(MockDataDTO dto) {

        Page<MockDataDao> page = mockDataRepository.findAll(dto.pageRequest().withSort(sort()));
        return PageMapper.INSTANCE.toDTO(page, MockDataMapper.INSTANCE::toDTOs);
    }

    @Override
    public PageDTO<MockDataDTO> queryByName(MockDataDTO dto) {

        Page<MockDataDao> page = mockDataRepository.queryByName(dto.getName(), dto.pageRequest().withSort(sort()));
        return PageMapper.INSTANCE.toDTO(page, MockDataMapper.INSTANCE::toDTOs);
    }

    @Override
    public List<MockDataDTO> all() {
        return MockDataMapper.INSTANCE.toDTOs(mockDataRepository.findAll(sort()));
    }

    @Async
    @Override
    public void run(MockDataDTO dto) {

        if (StringUtils.hasText(dto.getId())) {
            update(dto);
        } else {
            add(dto);
        }

        List<ModelDao> modelDaoList = modelRepository.queryByIdIn(dto.getComponentIds());
        String groupId = ID.groupId();

        for (ModelDao modelDao : modelDaoList) {
            ModelInput input = ModelMapper.INSTANCE.toInput(modelDao);
            input.setMsg(dto.getData());
            ModelEu modelEu = modelEuFactory.get(input);

            Output output = modelEu.call();
            MockResultDTO resultDTO = new MockResultDTO();

            resultDTO.setGroupId(groupId);
            resultDTO.setDataId(dto.getId());
            resultDTO.setType(dto.getType());
            resultDTO.setComponentId(modelDao.getId());
            resultDTO.setData(dto.getData());
            resultDTO.setResult(output.content().toString());
            mockResultService.add(resultDTO);
        }
    }

    private Sort sort() {
        return Sort.by(Sort.Direction.DESC, "createTime");
    }
}
