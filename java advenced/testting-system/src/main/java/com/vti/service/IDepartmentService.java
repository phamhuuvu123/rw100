package com.vti.service;

import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentDTO> findall();
    DepartmentDTO findById(Integer id);
    void deleteById(Integer id);
    void update(DepartmentDTO department,Integer id);
    void create(DepartmentDTO department);

    Department findByName(String name);
}
