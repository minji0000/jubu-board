package com.jubu.controller;

import com.jubu.dto.AuthDTO;
import com.jubu.entity.Auth;
import com.jubu.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth") 
public class AuthController {

    @Autowired
    private AuthService authService;

    /* 회원가입 */
    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody AuthDTO joinRequest) {
        try {
            // 서비스에서 중복 체크 및 저장을 처리합니다.
            authService.join(joinRequest);
            return ResponseEntity.ok("회원가입이 완료되었습니다.");
        } catch (RuntimeException e) {
            // 중복된 아이디 등의 예외 처리
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    /* 로그인 */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDTO loginRequest, HttpSession session) {
        Auth loginUser = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
        
        if (loginUser != null) {
            // 세션에는 필요한 정보만 담거나, 반환 시에도 DTO로 변환하는 것이 좋음.
            session.setAttribute("user", loginUser.getUsername()); 
            return ResponseEntity.ok("로그인 성공!");
        }
        
        return ResponseEntity.status(401).body("로그인 정보가 올바르지 않습니다.");
    }
}