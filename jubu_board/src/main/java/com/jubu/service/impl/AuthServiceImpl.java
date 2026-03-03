package com.jubu.service.impl;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jubu.dto.AuthDTO;
import com.jubu.entity.Auth;
import com.jubu.repository.AuthRepository;
import com.jubu.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthRepository authRepository; // Repository도 AuthRepository로!

    @Override
    @Transactional(readOnly = true)
    public Auth login(String username, String password) {
        // 아이디로 사용자 조회
        Auth auth = authRepository.findByUsername(username);
        
        // 사용자가 존재하고 비밀번호가 일치하는지 확인
        if (auth != null && auth.getPassword().equals(password)) {
            return auth;
        }
        
        return null; // 인증 실패 시 null 반환
    }
    
    @Override
    @Transactional
    public void join(AuthDTO authDTO) { 
        
        // 1. 대소문자 무시 중복 체크 (JPA 쿼리 메소드 활용)
        if (authRepository.existsByUsernameIgnoreCase(authDTO.getUsername())) {
            throw new RuntimeException("이미 사용 중인 아이디입니다.");
        }

        // 2. DTO를 Entity로 변환 (패스워드 암호화는 나중에!)
        Auth auth = Auth.builder()
                .username(authDTO.getUsername())
                .password(authDTO.getPassword())
                .build();

        authRepository.save(auth);
    }
}