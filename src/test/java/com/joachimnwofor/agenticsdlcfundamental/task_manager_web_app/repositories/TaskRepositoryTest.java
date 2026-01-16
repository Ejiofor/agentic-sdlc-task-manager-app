package com.joachimnwofor.agenticsdlcfundamental.task_manager_web_app.repositories;

import com.joachimnwofor.agenticsdlcfundamental.task_manager_web_app.models.Task;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TaskRepositoryTest {
    @Mock
    private TaskRepository taskRepository;
    
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByTitleContainingIgnoreCase() {
        Task task1 = new Task("Alpha", "Desc", null);
        Task task2 = new Task("Beta", "Desc", null);
        when(taskRepository.findByTitleContainingIgnoreCase("a")).thenReturn(Arrays.asList(task1, task2));
        List<Task> result = taskRepository.findByTitleContainingIgnoreCase("a");
        assertEquals(2, result.size());
    }
}
