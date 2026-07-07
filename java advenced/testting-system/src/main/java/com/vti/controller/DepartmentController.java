package com.vti.controller;

import com.vti.Reporisoty.IDepartmenRepository;
import com.vti.entity.Department;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> findAll(){
        List<Department> departments = departmentService.findall();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
    // lay thong tin department theo thong tin
    @GetMapping("/{idSerach}")
    public ResponseEntity<Department> findbyId(@PathVariable(name="idSearch") Integer id   ){
       Department department = departmentService.findById(id);
       // neu doi tuong ko co gia tri gan luon gia null
        return new ResponseEntity<>(department,HttpStatus.OK);
    }
    @DeleteMapping("/{idDelete}")
    public ResponseEntity<String> deleteById(@PathVariable(name="IdDelete") Integer id   ){
        departmentService.deleteById(id);
        return new ResponseEntity<>("Xoa thanh cong",HttpStatus.OK);
    }
    // tao moi depatment
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Department department){
         departmentService.create(department);
        return  new ResponseEntity<>("tao moi thanh cong",HttpStatus.OK);

    }
    @PutMapping("/{idUpdate}")
    public ResponseEntity<String> update(@RequestBody Department department,
                                         @PathVariable(name="idUpdate")Integer id)
    {   departmentService.update(department,id);
        return new ResponseEntity<>("update thanh cong",HttpStatus.OK);
    }
}
