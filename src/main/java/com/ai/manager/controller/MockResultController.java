package com.ai.manager.controller;

import com.ai.manager.MockResultService;
import com.ai.manager.dto.MockResultDTO;
import com.ai.manager.dto.PageDTO;
import com.ai.manager.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: MockResultController
 * @description:
 * @author: zhangfan
 */
@RestController
@RequestMapping("/mock/result")
public class MockResultController {

    @Autowired
    private MockResultService mockResultService;

    @PostMapping("/add")
    public ResponseDTO<MockResultDTO> add(@RequestBody MockResultDTO dto) {
        return ResponseDTO.ok(mockResultService.add(dto));
    }

    @PostMapping("/update")
    public ResponseDTO<MockResultDTO> update(@RequestBody MockResultDTO dto) {
        mockResultService.update(dto);
        return ResponseDTO.ok();
    }

    @GetMapping("/list")
    public ResponseDTO<PageDTO<MockResultDTO>> queryList(MockResultDTO dto) {
        return ResponseDTO.ok(mockResultService.queryList(dto));
    }

    @GetMapping("/all")
    public ResponseDTO<List<MockResultDTO>> all() {
        return ResponseDTO.ok(mockResultService.all());
    }

}
