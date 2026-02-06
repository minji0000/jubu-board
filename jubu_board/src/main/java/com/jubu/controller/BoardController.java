package com.jubu.controller;

import com.jubu.entity.Board;
import com.jubu.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // JSON 응답을 위해 @Controller 대신 사용합니다.
@RequestMapping("/api/board") // 모든 주소 앞에 /api/board가 붙습니다.
public class BoardController {

	@Autowired
    private BoardService boardService; // 리포지토리 대신 서비스 주입

	@GetMapping("/list")
    public List<Board> list() {
        return boardService.getBoardList();
    }
	
	@PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Board board) {
        try {
            // 로그인 확인 없이 바로 전달받은 객체를 저장합니다.
            boardService.saveBoard(board);
            return ResponseEntity.ok("게시글 저장 성공!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("저장 실패: " + e.getMessage());
        }
    }
	
	// 특정 게시글 삭제 (Soft Delete 작동 확인용)
    @DeleteMapping("/delete/{boardId}")
    public ResponseEntity<String> delete(@PathVariable("boardId") Integer boardId) {
        try {
            boardService.deleteBoard(boardId); // 서비스의 삭제 메서드 호출
            return ResponseEntity.ok(boardId + "번 게시글이 삭제되었습니다. (Soft Delete)");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("삭제 실패: " + e.getMessage());
        }
    }
}