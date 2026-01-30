package com.jubu.repository;

import org.springframework.data.jpa.repository.JpaRepository; // 1. 임포트 추가
import com.jubu.entity.Auth;

// <엔티티 클래스명, ID의 타입> 순서로 적어주세요.
public interface AuthRepository extends JpaRepository<Auth, Integer> {

    Auth findByUsername(String username);

}