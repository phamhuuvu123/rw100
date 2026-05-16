package org.example.backend.service.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.service.IDdepartmentservice;
import org.example.entity.DePartment;

import java.util.List;

public class DepartmentServiceImpl implements IDdepartmentservice {
    private IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
    @Override
    public List<DePartment> findAll() {
        List<DePartment> dePartments = departmentRepository.findAll();
        return dePartments;
    }

    @Override
    public boolean insertDepartment(String name) {
        boolean  checkdePartments =departmentRepository.insertDepartment(name);
        return checkdePartments;
    }

    @Override
    public boolean deleteDepartment(int id) {
        boolean check = departmentRepository.deleteDepartment(id);
        if(check!=false)
        {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDepartment(int id, String name) {
        boolean check =departmentRepository.updateDepartment(id,name);
        if(check!=false)
        {
            return  true;
        }
        return false;
    }
}
