package com.joachimnwofor.agenticsdlcfundamental.task_manager_web_app;

import com.joachimnwofor.agenticsdlcfundamental.task_manager_web_app.models.Task;
import com.joachimnwofor.agenticsdlcfundamental.task_manager_web_app.repositories.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TaskControllerTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private com.joachimnwofor.agenticsdlcfundamental.task_manager_web_app.controllers.TaskController taskController;

    private Task task1;
    private Task task2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        task1 = new Task("Title1", "Desc1", null);
        task1.setId(1L);
        task2 = new Task("Title2", "Desc2", null);
        task2.setId(2L);
    }

    @Test
    void testGetAllTasks() {
        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));
        List<Task> tasks = taskController.getAllTasks(null);
        assertEquals(2, tasks.size());
    }

    @Test
    void testGetTaskById_Found() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task1));
        ResponseEntity<Task> response = taskController.getTaskById(1L);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(task1, response.getBody());
    }

    @Test
    void testGetTaskById_NotFound() {
        when(taskRepository.findById(99L)).thenReturn(Optional.empty());
        ResponseEntity<Task> response = taskController.getTaskById(99L);
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    void testCreateTask() {
        when(taskRepository.save(any(Task.class))).thenReturn(task1);
        ResponseEntity<Task> response = taskController.createTask(task1);
        assertTrue(response.getStatusCode().is2xxSuccessful() || response.getStatusCode().is3xxRedirection());
        assertEquals(task1, response.getBody());
    }

    @Test
    void testUpdateTask_Found() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task1));
        when(taskRepository.save(any(Task.class))).thenReturn(task1);
        Task update = new Task("Updated", "UpdatedDesc", null);
        ResponseEntity<Task> response = taskController.updateTask(1L, update);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    void testUpdateTask_NotFound() {
        when(taskRepository.findById(99L)).thenReturn(Optional.empty());
        Task update = new Task("Updated", "UpdatedDesc", null);
        ResponseEntity<Task> response = taskController.updateTask(99L, update);
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    void testDeleteTask_Found() {
        when(taskRepository.existsById(1L)).thenReturn(true);
        doNothing().when(taskRepository).deleteById(1L);
        ResponseEntity<Void> response = taskController.deleteTask(1L);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    void testDeleteTask_NotFound() {
        when(taskRepository.existsById(99L)).thenReturn(false);
        ResponseEntity<Void> response = taskController.deleteTask(99L);
        assertTrue(response.getStatusCode().is4xxClientError());
    }
}
