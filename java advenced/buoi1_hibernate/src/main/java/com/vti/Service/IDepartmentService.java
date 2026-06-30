package com.vti.Service;

import com.vti.enitity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll();
    Department findId(Integer id);
    void create(String name);
    void update(String name,Integer id);
}
