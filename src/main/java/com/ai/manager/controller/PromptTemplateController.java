package com.ai.manager.controller;

import com.ai.manager.PromptTemplateService;
import com.ai.manager.dto.PageDTO;
import com.ai.manager.dto.PromptTemplateDTO;
import com.ai.manager.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: PromptTemplateController
 * @description:
 * @author: zhangfan
 */
@RestController
@RequestMapping("/promptTemplate")
public class PromptTemplateController {
    @Autowired
    private PromptTemplateService promptTemplateService;

    @PostMapping("/add")
    public ResponseDTO<PromptTemplateDTO> add(@RequestBody PromptTemplateDTO dto) {
        return ResponseDTO.ok(promptTemplateService.add(dto));
    }

    @PostMapping("/update")
    public ResponseDTO<Void> update(@RequestBody PromptTemplateDTO dto) {
        promptTemplateService.update(dto);
        return ResponseDTO.ok();
    }

    @GetMapping("/qname")
    public ResponseDTO<PageDTO<PromptTemplateDTO>> queryByName(PromptTemplateDTO dto) {
        return ResponseDTO.ok(promptTemplateService.queryByName(dto));
    }

    @GetMapping("/list")
    public ResponseDTO<PageDTO<PromptTemplateDTO>> queryList(PromptTemplateDTO dto) {
        return ResponseDTO.ok(promptTemplateService.queryList(dto));
    }

    @GetMapping("/all")
    public ResponseDTO<List<PromptTemplateDTO>> all() {
        return ResponseDTO.ok(promptTemplateService.all());
    }
}
