package com.jubu.service;

import java.util.List;

import com.jubu.entity.Board;

public interface BoardService {
    List<Board> getBoardList(); // 전체 목록 조회

    void saveBoard(Board board); // 저장 기능 
}