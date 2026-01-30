package com.jubu.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jubu.dto.CommentDTO;
import com.jubu.entity.Comment;
import com.jubu.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
	
	@Autowired
    private CommentService commentService;

	// 1. 특정 게시글의 댓글 목록 조회 (트리 구조)
    @GetMapping("/{boardId}")
    public ResponseEntity<List<CommentDTO>> list(@PathVariable("boardId") Integer boardId) {
        List<CommentDTO> commentTree = commentService.getCommentsByBoard(boardId);
        return new ResponseEntity<>(commentTree, HttpStatus.OK);
    }

    // 2. 댓글 등록
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody CommentDTO commentDTO) {
        commentService.registerComment(commentDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    // 3. 댓글 수정
    @PutMapping("/modify")
    public ResponseEntity<String> modify(@RequestBody CommentDTO commentDTO) {
        commentService.modifyComment(commentDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    // 4. 댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<String> remove(@PathVariable("commentId") Integer commentId) {
        commentService.removeComment(commentId);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}