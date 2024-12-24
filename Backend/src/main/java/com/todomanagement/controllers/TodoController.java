package com.todomanagement.controllers;

import com.todomanagement.dto.TodoDto;
import com.todomanagement.services.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class TodoController
    {
        private TodoService todoService;

//        Build Add Todo Rest Api

        @PostMapping("/add")
        public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){

            TodoDto savedTodoDto = todoService.addTodo(todoDto);
            return new ResponseEntity<>(savedTodoDto, HttpStatus.CREATED);
        }

//        Build Get Todo Rest Api

        @GetMapping("/get/{id}")
        public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long id){

            TodoDto gettedTodoDto = todoService.getTodo(id);
            return new ResponseEntity<>(gettedTodoDto,HttpStatus.FOUND);
        }

//        Build Get ALl Todo Rest Api

        @GetMapping("/getAll")
        public ResponseEntity<List<TodoDto>> getAllTodo(){
            List<TodoDto> getAllTodo = todoService.getAllTodo();
            return ResponseEntity.ok(getAllTodo);
        }

//        Build Update Todo Rest Api
        @PutMapping("/update/{id}")
        public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long id){

            return ResponseEntity.ok(todoService.updateTodo(todoDto,id));
        }

//        Build Delete Todo Rest Api

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id){
            todoService.deleteTodo(id);
            return ResponseEntity.ok("Delete Successfully");
        }

//        Build Completed Todo Rest Api

        @PatchMapping("/completed/{id}")
        public ResponseEntity<TodoDto> completed(@PathVariable("id") Long id){
            return ResponseEntity.ok(todoService.completeTodo(id));
        }

//        Build In Completed Todo Rest Api

        @PatchMapping("/inCompleted/{id}")
        public ResponseEntity<TodoDto> inCompleted(@PathVariable("id") Long id){
            return ResponseEntity.ok(todoService.inCompleteTodo(id));
        }


    }
