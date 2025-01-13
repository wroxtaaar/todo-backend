package com.app.todo.controller;


import com.app.todo.dto.TodoDto;
import com.app.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;


    @GetMapping
    public ResponseEntity<List<TodoDto>> allTodos() {
        List<TodoDto> allTodos = todoService.getAllTodos();
        return ResponseEntity.ok(allTodos);
    }

    //Build Add todo REST API
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        TodoDto addTodoDto =  todoService.addTodo(todoDto);
        return new ResponseEntity<>(addTodoDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long id) {
        TodoDto TodoDto = todoService.getTodo(id);
        return ResponseEntity.ok(TodoDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, @RequestBody TodoDto todoDto){
        TodoDto todoDto1 = todoService.updateDto(id, todoDto);
        return ResponseEntity.ok(todoDto1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        todoService.delete(id);
        return ResponseEntity.ok("Todo Deleted Successfully");
    }

    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> complete(@PathVariable Long id){
        TodoDto todoDto = todoService.completeTodo(id);
        return ResponseEntity.ok(todoDto);
    }

    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> incomplete(@PathVariable Long id){
        TodoDto todoDto = todoService.incompleteTodoDto(id);
        return ResponseEntity.ok(todoDto);
    }

}
