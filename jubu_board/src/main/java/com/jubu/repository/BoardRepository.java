package com.jubu.repository;

import com.jubu.entity.Board; // 아까 만든 Board 엔티티의 경로

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    
    // JpaRepository<엔티티 클래스명, PK의 타입>을 상속받습니다.
    // 이것만으로도 글쓰기, 목록 보기, 상세 보기, 삭제 기능이 자동으로 완성돼요!
	    
    // isDeleted가 false인(0인) 게시글만 최신순으로 가져오기
    List<Board> findAllByIsDeletedFalseOrderByRegDateDesc();
}