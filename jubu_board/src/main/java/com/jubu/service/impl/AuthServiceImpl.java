package com.jubu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
}