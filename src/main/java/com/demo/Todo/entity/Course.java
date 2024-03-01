package com.demo.Todo.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "courses_table")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String description;
    private String status;
    @Column(name = "username")
    private String username;


    public Course(int id, String name, String description, String status, String username) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.username = username;
    }

    public Course() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
