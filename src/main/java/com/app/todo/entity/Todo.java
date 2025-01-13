package com.app.todo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data @Table(name = "todos")
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean completed;

}
