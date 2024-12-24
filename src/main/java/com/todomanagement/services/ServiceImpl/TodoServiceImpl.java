package com.todomanagement.services.ServiceImpl;

import com.todomanagement.dto.TodoDto;
import com.todomanagement.entities.Todo;
import com.todomanagement.exceptions.ResourceNotFoundException;
import com.todomanagement.repositories.TodoRepository;
import com.todomanagement.services.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {
    private TodoRepository todoRepository;

    private ModelMapper modelmapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
//                Convert TodoDto into Todo Jpa entity
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

//                Todo Jpa Entity
        Todo saveedTodo = todoRepository.save(todo);

//                Convert saved Todo Jpa Entity object into TodoDto
        TodoDto savedtodoDto = new TodoDto();
        savedtodoDto.setId(saveedTodo.getId());
        savedtodoDto.setTitle(saveedTodo.getTitle());
        savedtodoDto.setDescription(saveedTodo.getDescription());
        savedtodoDto.setCompleted(saveedTodo.isCompleted());

        return savedtodoDto;
    }

    public TodoDto getTodo(Long id) {

        Todo gettedTodo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No such id in the todo list" + id));

        return modelmapper.map(gettedTodo, TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodo() {

        List<Todo> todos = todoRepository.findAll();

        return todos.stream().map((todo) -> modelmapper.map(todo,TodoDto.class)).collect(Collectors.toList());
    }

    public TodoDto updateTodo(TodoDto todoDto, Long id){

         Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No such id exist"));
         todo.setTitle(todoDto.getTitle());
         todo.setDescription(todoDto.getDescription());
         todo.setCompleted(todoDto.isCompleted());

         Todo updatedTodo = todoRepository.save(todo);

         return modelmapper.map(updatedTodo, TodoDto.class);

    }

    public void deleteTodo(Long id){

        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No such id is exist"));
        todoRepository.deleteById(id);
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(("No such id is Exist")));
        todo.setCompleted(Boolean.TRUE);
        return modelmapper.map(todoRepository.save(todo), TodoDto.class);
    }



    @Override
    public TodoDto inCompleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(("No such id is Exist")));
        todo.setCompleted(Boolean.FALSE);
        return modelmapper.map(todoRepository.save(todo), TodoDto.class);
    }
}
