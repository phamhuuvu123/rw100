package org.example.backend.service;

import org.example.dto.CSV.DepartmentCSV;
import org.example.dto.context.DepartmentContext;
import org.example.entity.DePartment;

import java.util.List;

public interface IDdepartmentservice extends ImportFileCsv<DepartmentContext,DePartment, DepartmentCSV> {
    List<DePartment> findAll();
    boolean insertDepartment(String name);
    boolean deleteDepartment(int id);
    boolean updateDepartment(int id, String name);
    boolean checkExitId(Integer id);
    boolean checkExitIdAndName(String name,Integer id);
    String importDepartmentFromCSV(String pathname);

}
