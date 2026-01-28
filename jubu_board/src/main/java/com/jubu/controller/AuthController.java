package com.jubu.controller;

import com.jubu.domain.UserVO;
import com.jubu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserVO vo, HttpSession session) {
    	
        UserVO result = userMapper.login(vo);
        
        if (result != null) {
            session.setAttribute("user", result); // 세션 저장
            return ResponseEntity.ok(result);    // 유저 정보 반환
        }
        return ResponseEntity.status(401).body("fail");
    }
}