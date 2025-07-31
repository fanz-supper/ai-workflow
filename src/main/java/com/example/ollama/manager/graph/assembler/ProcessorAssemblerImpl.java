package com.example.ollama.manager.graph.assembler;

import com.example.ollama.manager.graph.ProcessorAssembler;
import com.example.ollama.manager.graph.attr.NodeIdAttr;
import com.example.ollama.manager.graph.attr.NodeNameAttr;
import com.example.ollama.manager.graph.attr.NodeServiceTypeAttr;
import com.example.ollama.manager.util.ID;
import com.example.ollama.workflow.flow.ForNodeProcessor;
import com.example.ollama.workflow.flow.NodeProcessor;
import com.example.ollama.workflow.flow.impl.ForNodeProcessorImpl;
import com.example.ollama.workflow.metadata.Input;
import com.example.ollama.workflow.metadata.serialize.handler.InputToEmptyString;
import com.example.ollama.workflow.metadata.serialize.handler.OutputToEmptyString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title: Integrate
 * @description:
 * @author: zhangfan
 */
public class ProcessorAssemblerImpl implements ProcessorAssembler {

    @Override
    public List<NodeProcessor<? extends Input>> assemble(List<NodeProcessor<? extends Input>> headers) {

        Map<String, NodeProcessor<? extends Input>> assambledMap = new HashMap<>();
        doAssemble(headers, assambledMap);

        return headers;
    }

    private void doAssemble(List<NodeProcessor<? extends Input>> nexts, Map<String, NodeProcessor<? extends Input>> assambledMap) {

        if (nexts == null) {
            return;
        }

        for (NodeProcessor<? extends Input> next : nexts) {

            NodeProcessor<? extends Input> np = next;
            String nodeId = np.getAttrV(NodeIdAttr.KEY);

            if (assambledMap.containsKey(nodeId)) {
                continue;
            }

            assambledMap.put(nodeId, np);
            if (np instanceof ForNodeProcessor.StartNodeProcessor statNode) {
                np = forNodeAssemble(statNode);
                assambledMap.put(np.getAttrV(NodeIdAttr.KEY), np);
            }

            doAssemble(np.nexts(), assambledMap);
        }
    }

    private NodeProcessor forNodeAssemble(ForNodeProcessor.StartNodeProcessor forStart) {

        ForNodeProcessorImpl forNodeProcessor = new ForNodeProcessorImpl();

        forNodeProcessor
                .putAttr(new NodeIdAttr(ID.uuid()))
                .putAttr(new NodeNameAttr("SystemForNode"))
                .putAttr(new NodeServiceTypeAttr("SystemFor"));

        forNodeProcessor.setInputSerializeHandler(new InputToEmptyString());
        forNodeProcessor.setOutputSerializeHandler(new OutputToEmptyString());

        ForNodeProcessor.EndNodeProcessor forEnd = findForEnd(forStart.nexts().get(0));

        forNodeProcessor.setNodeProcessors(forStart.nexts());
        forNodeProcessor.setForStartNode(forStart);
        forNodeProcessor.setForEndNode(forEnd);

        forStart.setNexts(List.of(forNodeProcessor));
        forNodeProcessor.addPre(forStart);

        forNodeProcessor.addNext(forEnd);
        forEnd.setPrevs(List.of(forNodeProcessor));

        return forEnd;
    }

    private ForNodeProcessor.EndNodeProcessor findForEnd(NodeProcessor<? extends Input> next) {

        while (!(next instanceof ForNodeProcessor.EndNodeProcessor)) {
            next = next.nexts().get(0);
        }

        return (ForNodeProcessor.EndNodeProcessor) next;
    }
}
