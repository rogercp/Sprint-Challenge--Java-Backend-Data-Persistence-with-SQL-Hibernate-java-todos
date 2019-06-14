package com.lambdaschool.todos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "todo")
public class Todo
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long todoid;

    @Column(nullable = false)
    private String description;

    private Date startDate;

    private Boolean completed=false;

    @ManyToOne
    @JoinColumn(name="userid")
    @JsonIgnoreProperties("todo")
    private User user;





}
