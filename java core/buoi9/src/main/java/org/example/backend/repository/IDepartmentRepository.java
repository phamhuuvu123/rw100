package org.example.backend.repository;

import org.example.entity.DePartment;

import java.util.List;
import java.util.Map;

public interface IDepartmentRepository {
    List<DePartment> findAll();
    boolean insertDepartment(String name);
    boolean deleteDepartment(int id);
    boolean updateDepartment(int id, String name);
    boolean checkExitId(Integer id);
    boolean checkExitIdAndName(String name,Integer id);
    boolean createListdepartment(List<DePartment> dePartments);
    Map<String,DePartment> mapByname();
}
