package com.jubu.service;

import com.jubu.dto.AuthDTO;
import com.jubu.entity.Auth;

public interface AuthService {
    Auth login(String username, String password);

	void join(AuthDTO joinRequest);
}