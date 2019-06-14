package com.lambdaschool.todos.controllers;


import com.lambdaschool.todos.model.Todo;
import com.lambdaschool.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/todos")
public class TodoController
{
    @Autowired
    private TodoService todoService;

    @PutMapping(value = "/todoid/{todoid}",
                consumes={"application/json"})
    public ResponseEntity<?> updateTodo(@PathVariable Long todoid, @RequestBody Todo todo)
    {
        todoService.update(todo,todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
