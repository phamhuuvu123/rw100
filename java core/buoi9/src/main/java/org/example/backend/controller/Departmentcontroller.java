package org.example.backend.controller;

import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.service.IDdepartmentservice;
import org.example.backend.service.impl.DepartmentServiceImpl;
import org.example.entity.DePartment;

import java.util.List;

public class Departmentcontroller {
    private IDdepartmentservice  departmentService= new DepartmentServiceImpl();
    public List<DePartment> findAll()
    {
    List<DePartment> dePartments = departmentService.findAll();
    return dePartments;
    }
    public boolean insertDepartment(String name)
    {
        boolean checkdepar = departmentService.insertDepartment(name);
        return checkdepar;
    }
    public boolean deleteDepartment(int id)
    {
        boolean check =departmentService.deleteDepartment(id);
        if(check!=false)return true;
        return false;
    }
    public boolean updateDepartmetn(int id,String name)
    {
        boolean check=departmentService.updateDepartment(id,name);
        if(check!=false) return true;
        return false;
    }
}
