package com.jubu.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class AuthDTO {
    private Integer userId;
    private String username;
    private String email;
    @JsonIgnore // JSON 결과(화면 전달)에서 비밀번호만 쏙 빼줍니다!
    private String password;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modDate;
}