package org.example.backend.service;

import org.example.entity.DePartment;

import java.util.List;

public interface IDdepartmentservice {
    List<DePartment> findAll();
    boolean insertDepartment(String name);
    boolean deleteDepartment(int id);
    boolean updateDepartment(int id, String name);
}
