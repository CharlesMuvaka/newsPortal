package org.example.dao;

import org.example.models.Department;

import java.util.List;

public interface DeptInterface {

    //Create
    void addDept(Department dept);

    //Read
    List<Department> allDepts();
    Department getDeptByID(int id);
}
