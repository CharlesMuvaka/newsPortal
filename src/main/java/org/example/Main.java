package org.example;

import com.google.gson.Gson;
import org.example.dao.DepartmentDao;
import org.example.dao.NewsDao;
import org.example.dao.WorkerDao;
import org.example.models.Department;
import org.example.models.News;
import org.example.models.Worker;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {

        Gson gson = new Gson();
        DepartmentDao deptDao = new DepartmentDao();
        WorkerDao workerDao  = new WorkerDao();
        NewsDao newsDao = new NewsDao();

        //Create a new Department
        post("/departments/new", "application/json", (req, res) -> { //accept a request in format JSON
            Department  dept = gson.fromJson(req.body(), Department.class);//make with GSON
            deptDao.addDept(dept);//Do our thing with our DAO
            res.status(201);//everything went well - update the response status code
            return gson.toJson(dept);//send it back to be displayed
        });





        

    }
}