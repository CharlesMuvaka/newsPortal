package org.example.dao;

import org.example.models.News;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

import static org.junit.jupiter.api.Assertions.*;

class NewsDaoTest {
    private NewsDao newsDao;
    private Connection conn;

    @BeforeEach
    void setUp() {
        newsDao = new NewsDao();
        conn = Db.sql2o.open();

    }

    @AfterEach
    void tearDown() {
        try(Connection conn = Db.sql2o.open()){
            String myQuery = "DELETE FROM news *";
             conn.createQuery(myQuery).executeUpdate();
        }
    }

    @Test
    void addNews() {

        News news = new News(1, "Employee hiring", "We announce the hiring of two more It experts from google");
        News news1 = new News( "Employee hiring", "We announce the hiring of two more It experts from google");
        newsDao.addNews(news);
        newsDao.addNews(news1);

        assertTrue(newsDao.getAllNews().contains(news));
        assertTrue(newsDao.getAllNews().contains(news1));
    }

    @Test
    void getAllNews() {

        News news = new News(1, "Employee hiring", "We announce the hiring of two more It experts from google");
        News news1 = new News(1, "Employee hiring", "We announce the hiring of two more It experts from google");
        News news2 = new News( "Employee hiring", "We announce the hiring of two more It experts from google");
        News news3 = new News( "Employee hiring", "We announce the hiring of two more It experts from google");
        newsDao.addNews(news);
        newsDao.addNews(news1);
        newsDao.addNews(news2);
        newsDao.addNews(news3);

        assertEquals(4, newsDao.getAllNews().size());
    }

    @Test
    void getNewsById() {

        News news = new News(1, "Employee hiring", "We announce the hiring of two more It experts from google");
        News news1 = new News( "Employee hiring", "We announce the hiring of two more It experts from google");
        newsDao.addNews(news);
        newsDao.addNews(news1);

        int id = news.getId();
        int id1 = news1.getId();


        assertEquals(news, newsDao.getNewsById(id));
        assertEquals(news1, newsDao.getNewsById(id1));


    }

    @Test
    void newsInADept() {

        News news = new News(2, "Employee hiring", "We announce the hiring of two more It experts from google");
        News news1 = new News(2, "Employee hiring", "We announce the hiring of two more It experts from google");
        News news2 = new News(1, "Employee hiring", "We announce the hiring of two more It experts from google");
        News news3 = new News(1, "Employee hiring", "We announce the hiring of two more It experts from google");
        newsDao.addNews(news);
        newsDao.addNews(news1);
        newsDao.addNews(news2);
        newsDao.addNews(news3);

        int deptId = news.getDepartmentId();
        int dept1Id = news2.getDepartmentId();

        assertEquals(2, newsDao.newsInADept(deptId).size());
        assertEquals(2, newsDao.newsInADept(dept1Id).size());

    }
}