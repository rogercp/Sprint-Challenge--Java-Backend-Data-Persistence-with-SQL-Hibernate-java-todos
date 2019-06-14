package com.lambdaschool.todos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.h2.security.auth.impl.StaticRolesMapper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;


@Entity
@Table(name = "todo")
public class Todo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false)
    private String description;

    private String startDate;

    private Boolean completed=false;

    @ManyToOne
    @JoinColumn(name="userid")
    @JsonIgnoreProperties("todo")
    private User todouser;

    public Todo()
    {
    }


    public Todo(String description, String startDate, User user)
    {
        this.description = description;
        this.startDate =  startDate;
        this.todouser = user;
    }

//    public Todo(String description, DateTimeFormat startDate, Boolean completed, User user)
//    {
//        this.description = description;
//        this.startDate = startDate;
//        this.completed = completed;
//        this.user = user;
//    }

    public Todo(String description)
    {
        this.description = description;
    }

    public Todo(String description, Boolean completed)
    {
        this.description = description;
        this.completed = completed;
    }

    public long getTodoid()
    {
        return todoid;
    }

    public void setTodoid(long todoid)
    {
        this.todoid = todoid;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public Boolean isCompleted()
    {
        return completed;
    }

    public void setCompleted(Boolean completed)
    {
        this.completed = completed;
    }

    public User getTodouser()
    {
        return todouser;
    }

    public void setTodouser(User user)
    {
        this.todouser = user;
    }

    @Override
    public String toString()
    {
        return "Todo{" +
                "todoid=" + todoid +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", completed=" + completed +
                ", user=" + todouser +
                '}';
    }
}
