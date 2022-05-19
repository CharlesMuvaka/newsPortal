package org.example.dao;

import org.example.models.Department;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentDaoTest {
    private DepartmentDao dept;

    @BeforeEach
    void setUp() {
        dept = new DepartmentDao();
        Connection conn = Db.sql2o.open();

    }

    @AfterEach
    void tearDown() {
        try(Connection conn = Db.sql2o.open()){
            String delete = "DELETE FROM departments * ";
            conn.createQuery(delete).executeUpdate();
        }
    }

    @Test
    void addDept() {
        Department payments1 = new Department("Payments", "Facilitates monetary services");
        dept.addDept(payments1);

        assertTrue(dept.allDepts().contains(payments1));
    }

    @Test
    void allDepts() {
        Department payments1 = new Department("Payments", "Facilitates monetary services");
        Department payments2 = new Department("Payments", "Facilitates monetary services");
        Department payments3 = new Department("Payments", "Facilitates monetary services");
        Department payments4 = new Department("Payments", "Facilitates monetary services");

        dept.addDept(payments1);
        dept.addDept(payments2);
        dept.addDept(payments3);
        dept.addDept(payments4);

        assertEquals(4, dept.allDepts().size());
    }

    @Test
    void getDeptByID() {

        Department payments4 = new Department("Payments", "Facilitates monetary services");
        dept.addDept(payments4);
        int id = payments4.getId();

        assertEquals(payments4, dept.getDeptByID(id));
    }
}