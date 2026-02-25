package com.jubu.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional; // (O) 스프링 전용을 써야 합니다!
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jubu.dto.BoardDTO;
import com.jubu.entity.Board;
import com.jubu.repository.BoardRepository;
import com.jubu.service.BoardService;

@Service // 서비스 빈으로 등록
@Transactional
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BoardDTO> getBoardList() {
    	
    	List<Board> entities = boardRepository.findAllByIsDeletedFalseOrderByRegDateDesc();
    	
    	List<BoardDTO> dtos = new ArrayList<>();
        for (Board entity : entities) {
            BoardDTO dto = new BoardDTO();
            BeanUtils.copyProperties(entity, dto);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    @Transactional
    public void saveBoard(BoardDTO boardDTO) { // Board 대신 BoardDTO를 받습니다.
        Board board;

        if (boardDTO.getBoardId() != null) {
            // 1. 수정(Update)일 경우: 기존 엔티티를 불러와서 값만 변경 (더티 체킹 활용)
            board = boardRepository.findById(boardDTO.getBoardId())
                    .orElseThrow(() -> new RuntimeException("글을 찾을 수 없습니다."));
            board.setTitle(boardDTO.getTitle());
            board.setContent(boardDTO.getContent());
        } else {
            // 2. 신규 저장(Insert)일 경우: DTO를 엔티티로 변환
            board = Board.builder()
                    .title(boardDTO.getTitle())
                    .content(boardDTO.getContent())
                    .writerId(boardDTO.getWriterId())
                    .build();
        }

        boardRepository.save(board);
    }

	@Override
	public void deleteBoard(Integer boardId) {
		Board board = boardRepository.findById(boardId)
		        .orElseThrow(() -> new RuntimeException("글이 없어요!"));
		    board.delete(); // Soft Delete 호출!
		    // @Transactional이 붙어있어서 따로 save 안 해도 DB에 반영.
		
	}

}
