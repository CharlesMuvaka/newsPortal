package org.example.dao;

import org.example.models.News;
import org.sql2o.Connection;

import java.util.List;

public class NewsDao implements NewsInterface{

    @Override
    public void addNews(News news) {
        try(Connection conn = Db.sql2o.open()){
            String sql = "INSERT INTO news(topic, description, departmentid) VALUES(:topic,:description, :departmentId)";
             news.id = (int) conn.createQuery(sql, true)
                    .addParameter("topic", news.getTopic())
                    .addParameter("description", news.getDescription())
                    .addParameter("departmentId", news.getDepartmentId())
                    .executeUpdate()
                    .getKey();
        }
    }

    @Override
    public List<News> getAllNews() {
       try(Connection conn = Db.sql2o.open()){
           String myQuery = "SELECT * FROM news";
           return conn.createQuery(myQuery).throwOnMappingFailure(false).executeAndFetch(News.class);
       }
    }

    @Override
    public News getNewsById(int id) {
        try(Connection conn = Db.sql2o.open()){
            String myQuery = "SELECT * FROM news WHERE id = :id";
            return  conn.createQuery(myQuery).addParameter("id", id).throwOnMappingFailure(false).executeAndFetchFirst(News.class);
        }
    }

    @Override
    public List<News> newsInADept(int deptId) {
        try(Connection conn = Db.sql2o.open()){
            String myQuery = "SELECT * FROM news WHERE departmentid = :deptId";
            return  conn.createQuery(myQuery).addParameter("deptId", deptId).executeAndFetch(News.class);
        }
    }
}
