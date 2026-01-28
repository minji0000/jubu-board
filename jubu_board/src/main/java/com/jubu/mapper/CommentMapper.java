package com.jubu.mapper;

import java.util.List;

import com.jubu.domain.CommentVO;

public interface CommentMapper {
    public void insert(CommentVO comment); // 댓글/대댓글 등록
    public List<CommentVO> getListByBoard(int boardId); // 특정 게시글의 모든 댓글 가져오기
}