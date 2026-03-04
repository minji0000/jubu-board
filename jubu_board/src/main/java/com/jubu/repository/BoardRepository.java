package com.jubu.repository;

import com.jubu.entity.Board; // 아까 만든 Board 엔티티의 경로

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    
	List<Board> findAllByOrderByRegDateDesc();
}