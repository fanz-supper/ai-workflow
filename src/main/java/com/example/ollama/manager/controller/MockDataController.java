package com.example.ollama.manager.controller;

import com.example.ollama.manager.MockDataService;
import com.example.ollama.manager.dto.MockDataDTO;
import com.example.ollama.manager.dto.PageDTO;
import com.example.ollama.manager.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title: MockDataController
 * @description:
 * @author: zhangfan
 */
@RestController
@RequestMapping("/mock/data")
public class MockDataController {

    @Autowired
    private MockDataService mockDataService;

    @PostMapping("/add")
    public ResponseDTO<MockDataDTO> add(@RequestBody MockDataDTO dto) {
        return ResponseDTO.ok(mockDataService.add(dto));
    }

    @PostMapping("/update")
    public ResponseDTO<MockDataDTO> update(@RequestBody MockDataDTO dto) {
        mockDataService.update(dto);
        return ResponseDTO.ok();
    }

    @GetMapping("/qname")
    public ResponseDTO<PageDTO<MockDataDTO>> queryByName(@RequestBody MockDataDTO dto) {
        return ResponseDTO.ok(mockDataService.queryByName(dto));
    }

    @GetMapping("/list")
    public ResponseDTO<PageDTO<MockDataDTO>> queryList(MockDataDTO dto) {
        return ResponseDTO.ok(mockDataService.queryList(dto));
    }

    @GetMapping("/all")
    public ResponseDTO<List<MockDataDTO>> all() {
        return ResponseDTO.ok(mockDataService.all());
    }

    @PostMapping("/run")
    public ResponseDTO<Void> run(@RequestBody MockDataDTO dto) {

        mockDataService.run(dto);
        return ResponseDTO.ok();
    }
}
