package org.example.backend.service.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.service.IDdepartmentservice;
import org.example.entity.DePartment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.ArrayList;
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
        if(!pathname.endsWith(".csv"))
        {
            return "định dạng không đúng";
        }
        boolean checkCrete=false;
        List<DePartment> dePartments = new ArrayList<>();
        try(BufferedReader br =new BufferedReader(new FileReader(pathname)))
        {
            String line= br.readLine();
            while ((line = br.readLine())!=null)
            {
                String[] fileds = line.split(",");
                String department =fileds[0];
                DePartment dep = new DePartment();
                dePartments.add(dep);
            }
            checkCrete =departmentRepository.createListdepartment(dePartments);
        }

        catch (Exception e)
        {
            e.printStackTrace();
        };
        return "Import thành công ";
    }

}
