package org.example.dao;

import org.example.models.Worker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorkerDaoTest {
    private WorkerDao dao;

    @BeforeEach
    void setUp() {
       Connection conn = Db.sql2o.open();
       dao = new WorkerDao();
    }

    @AfterEach
    void tearDown() {
        try(Connection conn = Db.sql2o.open()){
            String myQuery = "DELETE  FROM workers *";
            conn.createQuery(myQuery).executeUpdate();
        }
    }

    @Test
    void addWorker() {
        Worker manager1 = new Worker(1,"Charles Muvaka", "Manager");
        dao.addWorker(manager1);
        assertEquals(manager1, dao.allWorkers().get(0));
    }

    @Test
    void getWorkerById() {
        Worker manager1 = new Worker(1,"Charles Muvaka", "Manager");
        dao.addWorker(manager1);
        int id = manager1.getId();

        assertEquals(manager1, dao.getWorkerById(id));
    }

    @Test
    void allWorkers() {
        Worker manager1 = new Worker(1,"Charles Muvaka", "Manager");
        Worker manager2 = new Worker(1,"Charles Muvaka", "Manager");
        Worker manager3 = new Worker(1,"Charles Muvaka", "Manager");
        dao.addWorker(manager1);
        dao.addWorker(manager2);
        dao.addWorker(manager3);

        assertEquals(3, dao.allWorkers().size());
    }

    @Test
    void getWorkersInDepartment(){
        Worker manager1 = new Worker(1,"Charles Muvaka", "Manager");
        Worker manager2 = new Worker(1,"Charles Muvaka", "Manager");
        Worker manager3 = new Worker(1,"Charles Muvaka", "Manager");
        dao.addWorker(manager1);
        dao.addWorker(manager2);
        dao.addWorker(manager3);


        List<Worker> sameDept = dao.getWorkersByDepartmentId(1);
        assertEquals(sameDept.size(), dao.getWorkersByDepartmentId(1).size());

    }
}