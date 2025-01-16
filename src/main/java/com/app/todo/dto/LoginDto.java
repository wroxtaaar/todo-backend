package com.app.todo.dto;


import lombok.Data;

@Data
public class LoginDto {

    private String usernameOrEmail;
    private String password;

}
