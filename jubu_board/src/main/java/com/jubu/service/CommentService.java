package com.jubu.service;

import java.util.List;

import com.jubu.entity.Comment;

public interface CommentService {
    void registerComment(Comment comment);
    List<Comment> getCommentsByBoard(int boardId);
}