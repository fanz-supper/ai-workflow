package com.ai.manager.controller;

import com.ai.manager.ModelService;
import com.ai.manager.dto.ModelDTO;
import com.ai.manager.dto.PageDTO;
import com.ai.manager.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: ModelController
 * @description:
 * @author: zhangfan
 */
@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @PostMapping("/add")
    public ResponseDTO<ModelDTO> add(@RequestBody ModelDTO dto) {
        return ResponseDTO.ok(modelService.add(dto));
    }

    @PostMapping("/update")
    public ResponseDTO<Void> update(@RequestBody ModelDTO dto) {
        modelService.update(dto);
        return ResponseDTO.ok();
    }

    @GetMapping("/qname")
    public ResponseDTO<PageDTO<ModelDTO>> queryByName(@RequestBody ModelDTO dto) {
        return ResponseDTO.ok(modelService.queryByName(dto));
    }

    @GetMapping("/list")
    public ResponseDTO<PageDTO<ModelDTO>> queryList(ModelDTO dto) {
        return ResponseDTO.ok(modelService.queryList(dto));
    }

    @GetMapping("/all")
    public ResponseDTO<List<ModelDTO>> all() {
        return ResponseDTO.ok(modelService.all());
    }

}
