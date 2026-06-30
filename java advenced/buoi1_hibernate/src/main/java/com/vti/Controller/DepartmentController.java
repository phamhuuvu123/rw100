package com.vti.Controller;

import com.vti.Service.impl.DepartmentService;
import com.vti.enitity.Department;

import java.util.List;

public class DepartmentController {
    private DepartmentService departmentService = new DepartmentService();
    public List<Department> findAll() {
        return departmentService.findAll();
    }
    public Department findId(Integer id) {
        return departmentService.findId(id);
    }
    public void create(String name) {
        departmentService.create(name);
    }
    public void update(String name, Integer id) {
        departmentService.update(name,id);
    }
}
