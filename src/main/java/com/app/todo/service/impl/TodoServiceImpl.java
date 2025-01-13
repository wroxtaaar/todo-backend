package com.app.todo.service.impl;

import com.app.todo.Exception.ResourceNotFoundException;
import com.app.todo.dto.TodoDto;
import com.app.todo.entity.Todo;
import com.app.todo.repository.TodoRepositopry;
import com.app.todo.service.TodoService;

import lombok.AllArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepositopry todoRepositopry;
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        Todo todo = modelMapper.map(todoDto, Todo.class);
        Todo savedTodo = todoRepositopry.save(todo);
        return modelMapper.map(savedTodo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepositopry.findAll();
        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class)).toList();
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepositopry.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with the given id: " + id));
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public TodoDto updateDto(Long id, TodoDto todoDto) {
        Todo todo = todoRepositopry.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with the given id: " + id));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());
        Todo updatedTodo = todoRepositopry.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void delete(Long id) {
        Todo todo = todoRepositopry.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with the given id: " + id));
        todoRepositopry.delete(todo);
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo = todoRepositopry.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Todo not found with the given id: " + id));
            todo.setCompleted(Boolean.TRUE);
            Todo updatedTodo = todoRepositopry.save(todo);
            return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public TodoDto incompleteTodoDto(Long id) {
        Todo todo = todoRepositopry.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Todo not found with the given id: " + id));
            todo.setCompleted(Boolean.FALSE);
            Todo updatedTodo = todoRepositopry.save(todo);
            return modelMapper.map(updatedTodo, TodoDto.class);
    }

}
