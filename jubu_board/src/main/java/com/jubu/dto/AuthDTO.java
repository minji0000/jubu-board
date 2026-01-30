package com.jubu.dto;

import lombok.Data;

@Data
public class AuthDTO {
    private Integer userId;
    private String username;
    private String email;
    private String password;
    
}