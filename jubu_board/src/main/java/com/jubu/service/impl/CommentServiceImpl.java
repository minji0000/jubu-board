package com.jubu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jubu.entity.Comment;
import com.jubu.repository.CommentRepository;
import com.jubu.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository; 

    @Override
    @Transactional
    public void registerComment(Comment comment) {
        commentRepository.save(comment); // insert 대신 save!
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> getCommentsByBoard(int boardId) {
        // JPA로 데이터 가져오기
        List<Comment> allComments = commentRepository.findByBoardIdOrderByCommentIdAsc(boardId);
        return convertToTree(allComments);
    }

    private List<Comment> convertToTree(List<Comment> comments) {
        List<Comment> rootComments = new ArrayList<>();
        Map<Integer, Comment> map = new HashMap<>();

        for (Comment comment : comments) {
            map.put(comment.getCommentId(), comment);
            
            // 부모가 없으면(0 또는 null) 루트 댓글
            if (comment.getParentId() == null || comment.getParentId() == 0) {
                rootComments.add(comment);
            } else {
                // 부모 댓글을 맵에서 찾아서 자식으로 추가
                Comment parent = map.get(comment.getParentId());
                if (parent != null) {
                    parent.getChildren().add(comment);
                }
            }
        }
        return rootComments;
    }
}