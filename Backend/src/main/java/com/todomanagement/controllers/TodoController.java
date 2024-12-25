package com.todomanagement.controllers;

import com.todomanagement.dto.TodoDto;
import com.todomanagement.services.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Makarand Milind Hinge
 * Email: mmh2212002@gmail.com
 * LinkedIn: linkedin.com/in/makarand-hinge
 *
 * This controller handles all Todo-related operations, including creation, retrieval, update, and deletion.
 */
@RestController
@RequestMapping("/api/todos")
@Tag(name = "Todo Management", description = "Operations related to managing Todo items")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Operation(summary = "Add a new Todo item", description = "Creates and returns a new Todo item")
    @PostMapping("/add")
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        todoDto.setId(null);
        TodoDto savedTodoDto = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodoDto, HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieve a specific Todo item", description = "Fetches a Todo item by its ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long id) {
        TodoDto gettedTodoDto = todoService.getTodo(id);
        return new ResponseEntity<>(gettedTodoDto, HttpStatus.OK);
    }

    @Operation(summary = "Retrieve all Todo items", description = "Fetches a list of all Todo items")
    @GetMapping("/getAll")
    public ResponseEntity<List<TodoDto>> getAllTodo() {
        List<TodoDto> getAllTodo = todoService.getAllTodo();
        return ResponseEntity.ok(getAllTodo);
    }

    @Operation(summary = "Update an existing Todo item", description = "Updates a Todo item based on its ID and new details")
    @PutMapping("/update/{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long id) {
        return ResponseEntity.ok(todoService.updateTodo(todoDto, id));
    }

    @Operation(summary = "Delete a specific Todo item", description = "Deletes a Todo item by its ID")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @Operation(summary = "Mark a Todo item as completed", description = "Updates the completion status of a Todo item to true")
    @PatchMapping("/completed/{id}")
    public ResponseEntity<TodoDto> completed(@PathVariable("id") Long id) {
        return ResponseEntity.ok(todoService.completeTodo(id));
    }

    @Operation(summary = "Mark a Todo item as incomplete", description = "Updates the completion status of a Todo item to false")
    @PatchMapping("/inCompleted/{id}")
    public ResponseEntity<TodoDto> inCompleted(@PathVariable("id") Long id) {
        return ResponseEntity.ok(todoService.inCompleteTodo(id));
    }
}
