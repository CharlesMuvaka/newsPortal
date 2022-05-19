package org.example.dao;

import org.example.models.Department;
import org.sql2o.Connection;

import java.util.List;

public class DepartmentDao implements DeptInterface{
    @Override
    public void addDept(Department dept) {

        try(Connection conn = Db.sql2o.open()){
            String myQuery = "INSERT INTO departments(name, description) VALUES(:name, :description)";
            dept.id = (int) conn.createQuery(myQuery)
                    .addParameter("name", dept.getName())
                    .addParameter("description", dept.getDescription())
                    .executeUpdate()
                    .getKey();
        }
    }

    @Override
    public List<Department> allDepts() {
        try(Connection conn = Db.sql2o.open()){
            String all = "SELECT * FROM departments";
            return conn.createQuery(all).executeAndFetch(Department.class);
        }
    }

    @Override
    public Department getDeptByID(int id) {
        try(Connection conn = Db.sql2o.open()){
            String one  = "SELECT * FROM departments WHERE id = :id";
            return conn.createQuery(one).addParameter("id", id).executeAndFetchFirst(Department.class);
        }
    }
}
