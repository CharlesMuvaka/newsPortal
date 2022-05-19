package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    Department payments = new Department("Payments", "Facilitates monetary services");
    Department payments1 = new Department("Payments", "Facilitates monetary services");


    @Test
    void testEquals() {

        assertTrue(payments.equals(payments1));
    }

    @Test
    void getName() {
        assertEquals("Payments", payments.getName());
    }

    @Test
    void getDescription() {
        assertEquals("Facilitates monetary services", payments.getDescription());
    }
}