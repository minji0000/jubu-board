package com.jubu.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional; // (O) 스프링 전용을 써야 합니다!

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Board> getBoardList() {
    	return boardRepository.findAllByIsDeletedFalseOrderByRegDateDesc();
    }

	@Override
	public void saveBoard(Board board) {
		// JPA의 save는 id가 없으면 INSERT, 있으면 UPDATE를 알아서 판단
		boardRepository.save(board);
	}

	@Override
	public void deleteBoard(Integer boardId) {
		boardRepository.deleteById(boardId);
		
	}

}
