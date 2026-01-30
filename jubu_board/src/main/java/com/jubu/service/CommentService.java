package com.jubu.service;

import java.util.List;

import com.jubu.dto.CommentDTO;

public interface CommentService {
	
	// 댓글 등록
    void registerComment(CommentDTO commentDTO);
    
    // 댓글 수정
    void modifyComment(CommentDTO commentDTO);
    
    // 댓글 삭제
    void removeComment(Integer commentId);
    
    // 특정 게시글의 댓글 목록을 트리 구조로 가져오기
    List<CommentDTO> getCommentsByBoard(Integer boardId);
}