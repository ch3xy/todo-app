package com.ebcont.todoapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Todo {

    @Id
    private Long id;
    private String task;
}
