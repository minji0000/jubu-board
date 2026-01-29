package com.jubu.controller;

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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Auth authRequest, HttpSession session) {
        
        Auth loginUser = authService.login(authRequest.getUsername(), authRequest.getPassword());
        
        if (loginUser != null) {
            // 세션에는 여전히 "user"라는 키로 저장해도 되고, "authUser"로 바꿔도 됩니다.
            session.setAttribute("user", loginUser); 
            return ResponseEntity.ok(loginUser);
        }
        
        return ResponseEntity.status(401).body("로그인 정보가 올바르지 않습니다.");
    }
}