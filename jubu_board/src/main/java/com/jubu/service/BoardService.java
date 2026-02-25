package com.jubu.service;

import java.util.List;

import com.jubu.dto.BoardDTO;

public interface BoardService {
    List<BoardDTO> getBoardList(); // 전체 목록 조회

    void saveBoard(BoardDTO board); // 저장 기능 

	void deleteBoard(Integer boardId);
}