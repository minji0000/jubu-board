package com.jubu.mapper;

import com.jubu.domain.BoardVO;
import java.util.List;

public interface BoardMapper {
    // 게시글 등록
    public void insert(BoardVO board);

    // 게시글 목록 가져오기
    public List<BoardVO> getList();
}