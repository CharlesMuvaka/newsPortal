package org.example.dao;

import org.example.models.Worker;

import java.util.List;

public interface WorkerInterface {
    //CREATE
    void addWorker(Worker worker);

    //READ
    Worker getWorkerById(int id);
    List<Worker> allWorkers();
    List<Worker> getWorkersByDepartmentId(int departmentId);

    //Update
    //Delete

}
