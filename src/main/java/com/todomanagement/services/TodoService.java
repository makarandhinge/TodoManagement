package com.todomanagement.services;

import com.todomanagement.dto.TodoDto;

import java.util.List;

public interface TodoService
    {
        TodoDto addTodo(TodoDto todoDto);

        TodoDto getTodo(Long id);

        List<TodoDto> getAllTodo();

        TodoDto updateTodo(TodoDto todoDto,Long id);

        void deleteTodo(Long id);

        TodoDto completeTodo(Long id);

        TodoDto inCompleteTodo(Long id);

    }
