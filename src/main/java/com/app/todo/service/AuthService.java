package com.app.todo.service;

import com.app.todo.dto.LoginDto;
import com.app.todo.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
