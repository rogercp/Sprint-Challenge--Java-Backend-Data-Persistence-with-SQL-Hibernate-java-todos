package com.lambdaschool.todos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usertodos")
public class UserTodos extends Auditable implements Serializable
{
    @Id
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnoreProperties({"userTodos","hibernateLazyInitializer"})
    @JoinColumn(name="todoid")
    private Todo todo;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"userTodos","hibernateLazyInitializer"})
    @JoinColumn(name = "userid")
    private User user;

    public UserTodos()
    {
    }

    public UserTodos(Todo todo, User user)
    {
        this.todo = todo;
        this.user = user;
    }

    public Todo getTodo()
    {
        return todo;
    }

    public void setTodo(Todo todo)
    {
        this.todo = todo;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof UserTodos))
        {
            return false;
        }
        UserTodos userTodos = (UserTodos) o;
        return getUser().equals(userTodos.getUser()) &&
                getTodo().equals(userTodos.getTodo());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUser(), getTodo());
    }
}
