package com.jubu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jubu.entity.Comment;
import com.jubu.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentService commentService; // 

    @PostMapping("/register")
    public String register(@RequestBody Comment comment) {
        commentService.registerComment(comment);
        return "success";
    }

    @GetMapping("/{boardId}")
    public List<Comment> getComments(@PathVariable int boardId) {
        return commentService.getCommentsByBoard(boardId);
    }
}