package com.jubu.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jubu.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    // 게시글 번호로 댓글 목록을 가져오는 메소드 (JPA가 알아서 쿼리 생성!)
    List<Comment> findByBoardIdOrderByCommentIdAsc(int boardId);
}