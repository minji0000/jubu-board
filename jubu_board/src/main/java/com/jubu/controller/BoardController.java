package com.jubu.controller;

import com.jubu.domain.BoardVO;
import com.jubu.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    @Autowired
    private BoardMapper boardMapper;

    // 1. 글쓰기 (POST)
    @PostMapping("/register")
    public String register(@RequestBody BoardVO board) {
        boardMapper.insert(board);
        return "success";
    }

    // 2. 목록 보기 (GET)
    @GetMapping("/list")
    public List<BoardVO> getList() {
        return boardMapper.getList();
    }
}