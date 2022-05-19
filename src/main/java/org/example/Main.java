package org.example;

import com.google.gson.Gson;
import org.example.dao.DepartmentDao;
import org.example.dao.NewsDao;
import org.example.dao.WorkerDao;
import org.example.exceptions.ApiException;
import org.example.models.Department;
import org.example.models.News;
import org.example.models.Worker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

            if(dept.getName().equals("")  || dept.getDescription().equals("")){
                throw new ApiException(404, "Please fill in the required fields");

            }else if(deptDao.allDepts().contains(dept)){
                throw new ApiException(404, "The department provided already exists");
            }else {
                deptDao.addDept(dept);//Do our thing with our DAO
                res.status(201);//everything went well - update the response status code
                return gson.toJson(dept);//send it back to be displayed
            }


        });


        //get all Departments
        get("/departments", "application/json", (req, res) -> { //accept a request in format JSON from an app


            System.out.println(deptDao.allDepts());
            return gson.toJson(deptDao.allDepts());//send it back to be displayed
        });

        //get Department by id
        get("/departments/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int deptId = Integer.parseInt(req.params("id"));
            Department dept = deptDao.getDeptByID(deptId);

            if(dept != null){
                return gson.toJson(dept);
            }else {
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }

        });

        //adding a new worker
        post("/worker/new","application/json" ,(request, response)->{
            Worker newWorker = gson.fromJson(request.body(), Worker.class);

            if (newWorker.getDepartmentId() <= 0 || newWorker.getName().equals("") || newWorker.getDepartmentPosition().equals("")){
                throw new ApiException(404, "Please fill in all the required fields");
            } else if (workerDao.allWorkers().contains(newWorker)) {
                throw new ApiException(404, "The worker already exists");
            }else{
                workerDao.addWorker(newWorker);

                response.status(201);
                System.out.println(newWorker);
                return gson.toJson(newWorker);
            }

        });

        //getting all workers
        get("/workers", "application/json", (req, res) -> { //accept a request in format JSON from an app


            System.out.println(workerDao.allWorkers());
            return gson.toJson(workerDao.allWorkers());//send it back to be displayed
        });

        //get a single worker by id
        get("/worker/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int workerId = Integer.parseInt(req.params(":id"));
            Worker worker = workerDao.getWorkerById(workerId);

            if(worker != null){
                return gson.toJson(worker);
            }else {
                throw new ApiException(404, String.format("No Worker with the id: \"%s\" exists", req.params("id")));
            }

        });

        //get workers in a department
        get("/dept/:id/workers", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int deptId = Integer.parseInt(req.params(":id"));
            Department dept = deptDao.getDeptByID(deptId);

            List<Worker> allWorkers = workerDao.getWorkersByDepartmentId(deptId);

            if(allWorkers.size() >= 1 ){
                return gson.toJson(allWorkers);
            } else if (dept == null) {
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));

            }
            else {
                return "{\"message\":\"Apologies, there are no available workers for this department.\"}";
            }

        });

        //Create new News
        post("/News/new","application/json" ,(request, response)->{
            News userNews = gson.fromJson(request.body(), News.class);

            if(userNews.getDepartmentId() <= 0 || userNews.getTopic().equals("") || userNews.getDescription().equals("")){
                throw new ApiException(404, "Please fill in all the required fields");
            }else if (newsDao.getAllNews().contains(userNews)){
                throw new ApiException(404, "The News article already exists");

            }else {
                newsDao.addNews(userNews);
                response.status(201);
                return gson.toJson(userNews);

            }


        });

        //get all News
        get("/news", "application/json", (req, res) -> { //accept a request in format JSON from an app


            System.out.println(newsDao.getAllNews());
            return gson.toJson(newsDao.getAllNews());//send it back to be displayed
        });


        //get a single  article
        get("/news/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int newsId = Integer.parseInt(req.params("id"));
            News newNews = newsDao.getNewsById(newsId);

            if (newNews != null){
                return gson.toJson(newsDao.getNewsById(newsId));

            }else {
                throw new ApiException(404, String.format("No News article with the id: \"%s\" exists", req.params("id")));
            }

        });

        //get News in a certain department
        get("/dept/:id/news", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int deptId = Integer.parseInt(req.params("id"));
            Department dept = deptDao.getDeptByID(deptId);

            List<News> allDeptNews = newsDao.newsInADept(deptId);

            if (allDeptNews.size() > 0){
                return gson.toJson(newsDao.newsInADept(deptId));

            }
            else if ( dept == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            else {
                return "{\"message\":\"Apologies, there are no available news for this department.\"}";

            }
        });


        exception(ApiException.class, (exc, req, res) -> {
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", ((ApiException) exc).getStatusCode());
            jsonMap.put("errorMessage", ((ApiException) exc).getMessage());
            res.type("application/json"); //after does not run in case of an exception.
            res.status(((ApiException) exc).getStatusCode()); //set the status
            res.body(gson.toJson(jsonMap));  //set the output.
        });

        after((req,res)-> res.type("application/json"));



        

    }
}