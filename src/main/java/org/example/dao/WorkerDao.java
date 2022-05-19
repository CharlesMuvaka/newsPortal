package org.example.dao;

import org.example.models.Worker;
import org.sql2o.Connection;

import java.util.List;

public class WorkerDao implements WorkerInterface{
    @Override
    public void addWorker(Worker worker) {

        try(Connection conn = Db.sql2o.open() ){
            String myQuery = "INSERT INTO workers(workername, workerposition, departmentid) VALUES(:workerName, :workerposition, :departmentId)";
            worker.id = (int) conn.createQuery(myQuery)
                    .addParameter("workerName", worker.getName())
                    .addParameter("workerposition", worker.getDepartmentPosition())
                    .addParameter("departmentId", worker.getDepartmentId())
                    .executeUpdate()
                    .getKey();
        }
    }

    @Override
    public Worker getWorkerById(int id) {
        try(Connection conn = Db.sql2o.open()){
            String myQuery = "SELECT * FROM workers WHERE id = :id";
            return conn.createQuery(myQuery).addParameter("id", id).executeAndFetchFirst(Worker.class);
        }
    }

    @Override
    public List<Worker> allWorkers() {
        try(Connection conn  = Db.sql2o.open()){
            String myQuery = "SELECT * FROM workers";
            return conn.createQuery(myQuery).executeAndFetch(Worker.class);
        }
    }

    @Override
    public List<Worker> getWorkersByDepartmentId(int departmentId) {
        try(Connection conn = Db.sql2o.open()){
            String myQuery = "SELECT * FROM workers WHERE departmentid = :departmentId";
            return conn.createQuery(myQuery).addParameter("departmentId", departmentId).executeAndFetch(Worker.class);
        }
    }
}
