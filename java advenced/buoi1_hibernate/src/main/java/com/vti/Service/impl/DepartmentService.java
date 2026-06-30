package com.vti.Service.impl;

import com.vti.Repository.IDepartmentRepository;
import com.vti.Repository.impl.DepartmentRepositoryimpl;
import com.vti.Service.IDepartmentService;
import com.vti.enitity.Department;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    private IDepartmentRepository iDepartmentRepository=  new DepartmentRepositoryimpl();
    @Override
    public List<Department> findAll() {
        return iDepartmentRepository.findAll();
    }

    @Override
    public Department findId(Integer id) {
        return iDepartmentRepository.findId(id);
    }

    @Override
    public void create(String name) {
    iDepartmentRepository.create(name);
    }

    @Override
    public void update(String name, Integer id) {
        iDepartmentRepository.update(name,id);
    }
}
