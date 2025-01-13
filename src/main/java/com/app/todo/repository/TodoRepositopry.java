package com.app.todo.repository;

import com.app.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepositopry extends JpaRepository<Todo, Long> {

}
