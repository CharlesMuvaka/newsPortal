package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {
    News hiring = new News(1,"Hiring","The following department has decided to hire ten new employees");
    News hiring1 = new News(1,"Hiring","The following department has decided to hire ten new employees");


    @Test
    void testEquals() {
        assertTrue(hiring.equals(hiring1));

    }


    @Test
    void getDepartmentId() {
        assertEquals(1, hiring.getDepartmentId());
    }

    @Test
    void getTopic() {
        assertEquals("Hiring", hiring.getTopic());
    }

    @Test
    void getDescription() {
        String expected = "The following department has decided to hire ten new employees";
        assertEquals(expected, hiring.getDescription());
    }
}