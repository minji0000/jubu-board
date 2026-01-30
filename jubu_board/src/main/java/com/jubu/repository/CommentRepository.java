package com.jubu.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jubu.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    // 특정 게시글 번호(boardId)에 해당하는 댓글만 리스트로 가져오기
    List<Comment> findByBoardId(Integer boardId);
    
    // 게시글 번호로 찾되, 댓글 번호 순서대로 정렬해서 가져오기!
    List<Comment> findByBoardIdOrderByCommentIdAsc(Integer boardId);
}