package com.jubu.controller;

import com.jubu.entity.Board;
import com.jubu.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // JSON 응답을 위해 @Controller 대신 사용합니다.
@RequestMapping("/api/board") // 모든 주소 앞에 /api/board가 붙습니다.
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    // 1. 전체 게시글 조회 (GET http://localhost:8080/api/board)
    @GetMapping
    public List<Board> getAllBoards() {
        return boardRepository.findAll(); // SQL 없이 전체 목록 조회
    }

    // 2. 게시글 상세 조회 (GET http://localhost:8080/api/board/1)
    @GetMapping("/{id}")
    public Board getBoardById(@PathVariable Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    // 3. 게시글 작성 (POST http://localhost:8080/api/board)
    // Postman에서 Body -> raw -> JSON 선택 후 데이터를 보내야 합니다.
    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return boardRepository.save(board); // 인서트(Insert) 실행
    }

    // 4. 게시글 삭제 (DELETE http://localhost:8080/api/board/1)
    @DeleteMapping("/{id}")
    public String deleteBoard(@PathVariable Long id) {
        boardRepository.deleteById(id);
        return "ID " + id + "번 게시글이 삭제되었습니다.";
    }
}