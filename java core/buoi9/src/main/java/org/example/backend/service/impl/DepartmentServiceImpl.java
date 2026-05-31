package org.example.backend.service.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.service.IDdepartmentservice;
import org.example.dto.CSV.DepartmentCSV;
import org.example.dto.ImportErro;
import org.example.dto.context.DepartmentContext;
import org.example.entity.DePartment;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean checkExitId(Integer id) {
        return departmentRepository.checkExitId(id);
    }

    @Override
    public boolean checkExitIdAndName(String name, Integer id) {

        return departmentRepository.checkExitIdAndName(name,id);
    }

    @Override
    public String importDepartmentFromCSV(String pathname) {
     String pathError="C:\\Users\\HP\\Desktop\\rw100\\csv\\output_error_department.csv";
    Map<String,DePartment> mapByname = departmentRepository.mapByname();
    DepartmentContext context = new DepartmentContext(mapByname);
    String message =this.importFileCSV(pathname,context,pathError);
    return message;
    }

    @Override
    public void validation(String line, DepartmentContext Context, List<DePartment> entities, List<ImportErro<DepartmentCSV>> importErros) {
        List<String> errors = new ArrayList<>();
        String[] fileds = line.split(",");
        String departmentName =fileds[0];
        if(Objects.isNull(departmentName)||departmentName.trim().isEmpty())
        { errors.add(" tên phòng ban không được để trống");
        }else if(departmentName.length()>100)
        {
            errors.add("tên phòng ban quá dài");
        }else if(Context.getMapBydepartmentName().get(departmentName)!=null){
            errors.add("tên phòng ban đã tồn tại");
        }

        if(errors.isEmpty())
        {
            DePartment dep = new DePartment(departmentName);
            entities.add(dep);
            Context.getMapBydepartmentName().put(departmentName,dep);
        }else {
            DepartmentCSV csv = new DepartmentCSV(departmentName);
            ImportErro  importErro1 = new ImportErro(csv,errors);
            importErros.add(importErro1);
        }
    }

    @Override
    public void savsAll(List<DePartment> entites) {
        departmentRepository.createListdepartment(entites);
    }

    @Override
    public void exportFileError(List<ImportErro<DepartmentCSV>> importErros, String partError) {
        if(!importErros.isEmpty())
        try{
                BufferedWriter bw = new BufferedWriter(new FileWriter(partError));
                bw.write("department_name,err6or_message");
                bw.newLine();
                for (ImportErro erros : importErros) {
                    String ln = erros.getLine() + "," + String.join("|", erros.getMessage());
                    bw.write(ln);
                    bw.newLine();
                }
                bw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
