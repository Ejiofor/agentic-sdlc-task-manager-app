package com.joachimnwofor.agenticsdlcfundamental.task_manager_web_app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

enum TaskStatus {
    TODO, IN_PROGRESS, DONE
}

// add dueDate field of type TimeStamp to the Task class below
@Entity
@Table(name = "taskdata")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private java.sql.Timestamp dueDate;
    @JsonIgnore
    @jakarta.persistence.Convert(converter = TaskStatusConverter.class)
    private TaskStatus status;

    // JPA requires a no-args constructor
    public Task() {}

    // Convenience constructor (id is generated)
    public Task(String title, String description, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public java.sql.Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(java.sql.Timestamp dueDate) {
        this.dueDate = dueDate;
    }
}