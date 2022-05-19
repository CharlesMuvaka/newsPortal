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





        

    }
}