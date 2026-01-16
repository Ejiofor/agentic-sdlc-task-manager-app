package com.joachimnwofor.agenticsdlcfundamental.task_manager_web_app.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    void testTaskConstructorAndGetters() {
        Task task = new Task("Title", "Desc", null);
        task.setId(10L);
        assertEquals(10L, task.getId());
        assertEquals("Title", task.getTitle());
        assertEquals("Desc", task.getDescription());
        // dueDate and status are ignored in this test
    }

    @Test
    void testSetters() {
        Task task = new Task();
        task.setId(5L);
        task.setTitle("T");
        task.setDescription("D");
        assertEquals(5L, task.getId());
        assertEquals("T", task.getTitle());
        assertEquals("D", task.getDescription());
        // dueDate and status are ignored in this test
    }
}
