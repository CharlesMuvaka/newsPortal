package org.example.dao;

import org.example.models.News;

import java.util.List;

public interface NewsInterface {

    //Add news
    void addNews(News news);

    //get all news
    List<News> getAllNews();

    //get news by id
    News getNewsById(int id);

    //get all news in a department
    List<News> newsInADept(int DeptId);
}
