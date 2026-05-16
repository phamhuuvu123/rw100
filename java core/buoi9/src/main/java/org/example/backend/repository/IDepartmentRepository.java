package org.example.backend.repository;

import org.example.entity.DePartment;

import java.util.List;

public interface IDepartmentRepository {
    List<DePartment> findAll();
    boolean insertDepartment(String name);
    boolean deleteDepartment(int id);
    boolean updateDepartment(int id, String name);
}
