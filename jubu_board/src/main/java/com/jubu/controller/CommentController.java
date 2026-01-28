package com.jubu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jubu.domain.CommentVO;
import com.jubu.mapper.CommentMapper;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;

    @PostMapping("/register")
    public String register(@RequestBody CommentVO comment) {
        commentMapper.insert(comment);
        return "success";
    }

    @GetMapping("/{boardId}")
    public List<CommentVO> getComments(@PathVariable int boardId) {
        List<CommentVO> allComments = commentMapper.getListByBoard(boardId);
        return convertToTree(allComments);
    }

    // ★ 무한 대댓글 조립 로직
    private List<CommentVO> convertToTree(List<CommentVO> comments) {
        List<CommentVO> rootComments = new ArrayList<>();
        Map<Integer, CommentVO> map = new HashMap<>();

        for (CommentVO comment : comments) {
            map.put(comment.getCommentId(), comment);
            if (comment.getParentId() == null || comment.getParentId() == 0) {
                rootComments.add(comment);
            } else {
                CommentVO parent = map.get(comment.getParentId());
                if (parent != null) {
                    parent.getChildren().add(comment);
                }
            }
        }
        return rootComments;
    }
}