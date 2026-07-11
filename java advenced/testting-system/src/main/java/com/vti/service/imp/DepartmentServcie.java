package com.vti.service.imp;

import com.vti.Reporisoty.IDepartmenRepository;
import com.vti.dto.AccountDTO;
import com.vti.dto.DepartmentDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vti.service.IDepartmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServcie implements IDepartmentService {
    @Autowired
    private IDepartmenRepository departmenRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<DepartmentDTO> findall() {
        List<Department> departments = departmenRepository.findAll();
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        for(Department department:departments)
        {
            DepartmentDTO dto= modelMapper.map(department,DepartmentDTO.class);
            departmentDTOS.add(dto);
        }
        return departmentDTOS;
    }

    @Override
    public DepartmentDTO findById(Integer id) {
       Department department= departmenRepository.findById(id).orElse(null);
       DepartmentDTO dto= null;
       if(Objects.nonNull(department)){
           dto=modelMapper.map(department,DepartmentDTO.class);
       }
       return dto;
    }

    @Override
    public void deleteById(Integer id) {
        departmenRepository.deleteById(id);
    }

    @Override
    public void update(DepartmentDTO departmentDTO, Integer id) {
    Department departmentupdate =departmenRepository.findById(id).orElse(null);
        if(Objects.isNull(departmentupdate)){
            throw new RuntimeException("id not found");
        }else {
            if(departmenRepository.existsByNameAndIdNot(departmentupdate.getName(),id)) {
            throw new RuntimeException("Deparment da ton tai");
            }
            departmentupdate.setName(departmentDTO.getName());
            departmenRepository.save(departmentupdate);
        }
    }

    @Override
    public void create(DepartmentDTO departmentDTO) {
        boolean check = departmenRepository.existsByNameAndIdNot(departmentDTO.getName(),null   );
        if(check==true)
        {
            throw  new RuntimeException("Department already exits");
        }
        Department department1 = new Department();
        department1.setName(departmentDTO.getName());
            departmenRepository.save(department1);

    }

    @Override
    public Department findByName(String name) {
        return departmenRepository.findByName(name);
    }
}
