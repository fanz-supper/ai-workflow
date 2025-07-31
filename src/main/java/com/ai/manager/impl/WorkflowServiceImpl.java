package com.ai.manager.impl;

import com.ai.manager.Status;
import com.ai.manager.WorkflowNodeResultService;
import com.ai.manager.WorkflowResultService;
import com.ai.manager.WorkflowService;
import com.ai.manager.dao.WorkflowDao;
import com.ai.manager.dto.PageDTO;
import com.ai.manager.dto.WorkflowDTO;
import com.ai.manager.dto.WorkflowNodeResultDTO;
import com.ai.manager.dto.WorkflowResultDTO;
import com.ai.manager.graph.Parser;
import com.ai.manager.graph.ProcessorAssembler;
import com.ai.manager.graph.attr.NodeIdAttr;
import com.ai.manager.graph.attr.NodeNameAttr;
import com.ai.manager.graph.attr.NodeServiceTypeAttr;
import com.ai.manager.graph.builder.NodeBuilderFactory;
import com.ai.manager.mapper.PageMapper;
import com.ai.manager.mapper.WorkflowMapper;
import com.ai.manager.repository.WorkflowRepository;
import com.ai.manager.util.ID;
import com.ai.workflow.flow.NodeProcessor;
import com.ai.workflow.flow.impl.DiagramProcessorImpl;
import com.ai.workflow.metadata.Input;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @title: WorkflowServiceImpl
 * @description:
 * @author: zhangfan
 */
@Service
public class WorkflowServiceImpl implements WorkflowService {

    @Autowired
    private WorkflowRepository workflowRepository;
    @Autowired
    private NodeBuilderFactory nodeBuilderFactory;
    @Autowired
    private ProcessorAssembler processorAssembler;
    @Autowired
    private WorkflowResultService resultService;
    @Autowired
    private WorkflowNodeResultService nodeResultService;

    @Override
    public WorkflowDTO add(WorkflowDTO dto) {

        WorkflowDao dao = WorkflowMapper.INSTANCE.toDAO(dto);
        dao.setId(ID.primaryId());
        dao.setStatus(Status.NONE.name());
        Date now = new Date();
        dao.setCreateTime(now);
        dao.setUpdateTime(now);

        WorkflowDao saved = workflowRepository.save(dao);
        return WorkflowMapper.INSTANCE.toDTO(saved);
    }

    @Override
    public void delete(WorkflowDTO dto) {

    }

    @Override
    public void update(WorkflowDTO dto) {

        workflowRepository.findById(dto.getId())
                .ifPresent(update -> {

                    WorkflowDao dao = WorkflowMapper.INSTANCE.toDAO(dto);
                    WorkflowMapper.INSTANCE.copyToIgnoreNull(dao, update);

                    update.setUpdateTime(new Date());
                    workflowRepository.save(update);
                });
    }

    @Override
    public PageDTO<WorkflowDTO> queryList(WorkflowDTO dto) {

        Page<WorkflowDao> all = workflowRepository.findAll(dto.pageRequest().withSort(sort()));
        return PageMapper.INSTANCE.toDTO(all, WorkflowMapper.INSTANCE::toDTOs);
    }

    @Override
    public PageDTO<WorkflowDTO> queryByName(WorkflowDTO dto) {

        Page<WorkflowDao> page = workflowRepository.queryByName(dto.getName(), dto.pageRequest().withSort(sort()));

        return PageMapper.INSTANCE.toDTO(page, WorkflowMapper.INSTANCE::toDTOs);
    }

    @Override
    public WorkflowDTO queryById(WorkflowDTO dto) {

        WorkflowDao dao = workflowRepository.findById(dto.getId()).orElseThrow();
        return WorkflowMapper.INSTANCE.toDTO(dao);
    }


    @Async
    @Override
    public void run(WorkflowDTO dto) {

        if (StringUtils.hasText(dto.getId())) {
            update(dto);
        } else {
            dto = add(dto);
        }

        Parser parser = new Parser(nodeBuilderFactory, processorAssembler);
        List<NodeProcessor<? extends Input>> headers = parser.parse(dto.getCanvas());

        DiagramProcessorImpl diagramProcessor = new DiagramProcessorImpl(headers);
        diagramProcessor.process();

        String groupId = ID.groupId();
        WorkflowResultDTO resultDTO = saveWorkflowResult(dto, groupId);

        Map<String, WorkflowNodeResultDTO> builtNodeResultMap = new HashMap<>();
        saveWorkflowNodeResult(resultDTO.getId(), headers, builtNodeResultMap);
        nodeResultService.addAll(builtNodeResultMap.values());

    }

    private WorkflowResultDTO saveWorkflowResult(WorkflowDTO dto, String groupId) {

        WorkflowResultDTO resultDTO = new WorkflowResultDTO();
        resultDTO.setWorkflowId(dto.getId());
        resultDTO.setGroupId(groupId);
        resultDTO.setName(dto.getName());
        resultDTO.setCanvas(dto.getCanvas());

        return resultService.add(resultDTO);
    }

    private void saveWorkflowNodeResult(String resultId, List<NodeProcessor<? extends Input>> nexts, Map<String, WorkflowNodeResultDTO> builtNodeResultMap) {

        if (nexts == null) {
            return;
        }

        for (NodeProcessor<? extends Input> next : nexts) {

            builtNodeResultMap.computeIfAbsent(next.getAttrV(NodeIdAttr.KEY), nodeId -> {

                WorkflowNodeResultDTO nodeResultDTO = new WorkflowNodeResultDTO();
                nodeResultDTO.setNodeId(nodeId);
                nodeResultDTO.setResultId(resultId);
                nodeResultDTO.setName(next.getAttrV(NodeNameAttr.KEY));
                nodeResultDTO.setServiceType(next.getAttrV(NodeServiceTypeAttr.KEY));
                nodeResultDTO.setInput(next.doInputSerialize());
                nodeResultDTO.setOutput(next.doOutputSerialize());

                return nodeResultDTO;
            });

            saveWorkflowNodeResult(resultId, next.nexts(), builtNodeResultMap);
        }

    }

    private Sort sort() {
        return Sort.by(Sort.Direction.DESC, "createTime");
    }
}
