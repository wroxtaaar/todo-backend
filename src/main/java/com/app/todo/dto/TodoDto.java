package com.app.todo.dto;

import lombok.Data;

@Data
public class TodoDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;

}
