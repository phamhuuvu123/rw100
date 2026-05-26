package org.example.backend.service.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.service.IDdepartmentservice;
import org.example.dto.ImportErro;
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
        File filea =new File(pathname);
        if(!filea.exists())
        {
            System.out.println("file không tồn tài");
        }
        if(!pathname.endsWith(".csv"))
        {
            return "định dạng không đúng";
        }
        boolean checkCrete=false;
        List<ImportErro> importErros =new ArrayList<>();
        List<DePartment> dePartments = new ArrayList<>();
        Map<String,DePartment> mapByname= departmentRepository.mapByname();
        try(BufferedReader br =new BufferedReader(new FileReader(pathname)))
        {
            String line= br.readLine();
            while ((line = br.readLine())!=null)
            {
                this.validation(line,mapByname,dePartments,importErros);
            }
             departmentRepository.createListdepartment(dePartments);
                String pathError="C:\\Users\\HP\\Desktop\\rw100\\csv\\output_error_department.csv";
                this.exportFileCsv(importErros,pathError);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        };
        String message ="";
        if(importErros.isEmpty())
        {
            message="Import thành công";
        }
        if(dePartments.isEmpty())
        {
            message="Import không thành công,đã xuất file lỗi //C:\\Users\\HP\\Desktop\\rw100\\csv\\output_error_department.csv";
        }
        if(!importErros.isEmpty()&&!dePartments.isEmpty())
        {
         message="import thành công " +dePartments.size()+", phòng ban "+ "đã xuất ra lỗi ở file//\"C:\\Users\\HP\\Desktop\\rw100\\csv\\output_erros_department\"";
        }
        return message;
    }

    public void exportFileCsv(List<ImportErro> importErros,String pathError)
    {
        try{

            BufferedWriter bw= new BufferedWriter( new FileWriter(pathError));
            bw.write("department_name,error_message");
            bw.newLine();
            for(ImportErro erros:importErros)
            {
                String ln= erros.getLine()+","+String.join("|",erros.getMessage());
                bw.write(ln);
                bw.newLine();
            }
            bw.flush();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void validation(String line,Map<String,DePartment> mapByname,List<DePartment> dePartments,
                            List<ImportErro> importErro)
    {
        List<String> errors = new ArrayList<>();
        String[] fileds = line.split(",");
        String departmentName =fileds[0];
        if(Objects.isNull(departmentName)||departmentName.trim().isEmpty())
        { errors.add(" tên phòng ban không được để trống");
        }else if(departmentName.length()>100)
        {
            errors.add("tên phòng ban quá dài");
        }else if(mapByname.get(departmentName)!=null){
            errors.add("tên phòng ban đã tồn tại");
        }

        if(errors.isEmpty())
        {
            DePartment dep = new DePartment(departmentName);
            dePartments.add(dep);
            mapByname.put(departmentName,dep);
        }else {
            ImportErro  importErro1 = new ImportErro(line,errors);
            importErro.add(importErro1);
        }
    }
}
