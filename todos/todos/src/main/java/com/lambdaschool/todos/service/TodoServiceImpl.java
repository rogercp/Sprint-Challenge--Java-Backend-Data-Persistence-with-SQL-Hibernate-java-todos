package com.lambdaschool.todos.service;

import com.lambdaschool.todos.model.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.hibernate.cache.cfg.internal.AbstractDomainDataCachingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService
{
    @Autowired
    private TodoRepository todorepos;


    @Override
    public Todo update(Todo todo, long id)
    {
        Todo currentTodo = todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (todo.getDescription()!=null) ;
        {
            currentTodo.setDescription(todo.getDescription());
        }
        if(todo.isCompleted() != currentTodo.isCompleted())
        {
            currentTodo.setCompleted(todo.isCompleted());
        }
        return todorepos.save(currentTodo);
    }
}
