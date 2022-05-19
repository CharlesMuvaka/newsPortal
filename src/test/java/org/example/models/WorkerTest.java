package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {

    Worker manager = new Worker(1,"Charles Muvaka", "Manager");
    Worker manager1 = new Worker(1,"Charles Muvaka", "Manager");

    @Test
    void testEquals() {
        assertTrue(manager.equals(manager1));
    }

    @Test
    void getDepartmentId() {
        assertEquals(1,manager.getDepartmentId());
    }

    @Test
    void getName() {
        assertEquals("Charles Muvaka", manager.getName());
    }

    @Test
    void getDepartmentPosition() {
        assertEquals("Manager", manager.getDepartmentPosition());
    }
}