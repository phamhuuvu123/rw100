package com.vti.Repository;

import com.vti.enitity.Department;

import java.util.List;

public interface IDepartmentRepository {
    List<Department> findAll();
    Department findId(Integer id);
    void create(String name);
    void update(String name,Integer id);
}
