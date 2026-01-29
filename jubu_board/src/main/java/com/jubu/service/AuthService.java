package com.jubu.service;

import com.jubu.entity.Auth;

public interface AuthService {
    Auth login(String username, String password);
}