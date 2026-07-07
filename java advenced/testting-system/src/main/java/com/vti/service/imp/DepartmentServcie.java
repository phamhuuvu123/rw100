package com.vti.service.imp;

import com.vti.Reporisoty.IDepartmenRepository;
import com.vti.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vti.service.IDepartmentService;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServcie implements IDepartmentService {
    @Autowired
    private IDepartmenRepository departmenRepository;

    @Override
    public List<Department> findall() {
        List<Department> departments =departmenRepository.findAll();
        return departments;
    }

    @Override
    public Department findById(Integer id) {
        Department department = departmenRepository.findById(id).get();
        return department;
    }

    @Override
    public void deleteById(Integer id) {
        departmenRepository.deleteById(id);
    }

    @Override
    public void update(Department department, Integer id) {
    Department departmentupdate =departmenRepository.findById(id).orElse(null);
        if(Objects.isNull(departmentupdate)){
            throw new RuntimeException("id not found");
        }else {
            departmentupdate.setName(department.getName());
            departmenRepository.save(departmentupdate);
        }
    }

    @Override
    public void create(Department department) {
        departmenRepository.save(department);
    }
}
