package com.app.todo.controller;


import com.app.todo.dto.TodoDto;
import com.app.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')") 
    @GetMapping
    public ResponseEntity<List<TodoDto>> allTodos() {
        List<TodoDto> allTodos = todoService.getAllTodos();
        return ResponseEntity.ok(allTodos);
    }

    //Build Add todo REST API
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        TodoDto addTodoDto =  todoService.addTodo(todoDto);
        return new ResponseEntity<>(addTodoDto, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long id) {
        TodoDto TodoDto = todoService.getTodo(id);
        return ResponseEntity.ok(TodoDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, @RequestBody TodoDto todoDto){
        TodoDto todoDto1 = todoService.updateDto(id, todoDto);
        return ResponseEntity.ok(todoDto1);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        todoService.delete(id);
        return ResponseEntity.ok("Todo Deleted Successfully");
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> complete(@PathVariable Long id){
        TodoDto todoDto = todoService.completeTodo(id);
        return ResponseEntity.ok(todoDto);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> incomplete(@PathVariable Long id){
        TodoDto todoDto = todoService.incompleteTodoDto(id);
        return ResponseEntity.ok(todoDto);
    }

}
