package com.app.todo.service;

import java.util.List;

import com.app.todo.dto.TodoDto;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    List<TodoDto> getAllTodos();

    TodoDto getTodo(Long id);

    TodoDto updateDto(Long id, TodoDto todoDto);

    void delete(Long id);

    TodoDto completeTodo(Long id);

    TodoDto incompleteTodoDto(Long id);
}
