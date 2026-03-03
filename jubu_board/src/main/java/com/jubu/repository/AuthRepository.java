package com.jubu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jubu.entity.Auth;

// <엔티티 클래스명, ID의 타입> 순서로 적어주세요.
public interface AuthRepository extends JpaRepository<Auth, Integer> {

    Auth findByUsername(String username);

//    대소문자가 달라도 같은 아이디로 취급해서 가입을 막는 정책 사용
	boolean existsByUsernameIgnoreCase(String username);

}