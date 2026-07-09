package com.vti.controller;

import com.vti.Reporisoty.IDepartmenRepository;
import com.vti.dto.DepartmentDTO;
import com.vti.entity.Department;
import com.vti.service.IDepartmentService;
import jakarta.websocket.server.PathParam;
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
    public ResponseEntity<List<DepartmentDTO>> findAll(){
        List<DepartmentDTO> departments = departmentService.findall();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }
    // lay thong tin department theo thong tin
    @GetMapping("/{idSearch}")
    public ResponseEntity<DepartmentDTO> findbyId(@PathVariable(name="idSearch") Integer id   ){
       DepartmentDTO departmentDTO = departmentService.findById(id);
       // neu doi tuong ko co gia tri gan luon gia null
        return new ResponseEntity<>(departmentDTO,HttpStatus.OK);
    }
    @DeleteMapping("/{idDelete}")
    public ResponseEntity<String> deleteById(@PathVariable(name="idDelete") Integer id   ){
        departmentService.deleteById(id);
        return new ResponseEntity<>("Xoa thanh cong",HttpStatus.OK);
    }
    // tao moi depatment
    @PostMapping
    public ResponseEntity<String> create(@RequestBody DepartmentDTO department){
         departmentService.create(department);
        return  new ResponseEntity<>("tao moi thanh cong",HttpStatus.OK);

    }
    @PutMapping("/{idUpdate}")
    public ResponseEntity<String> update(@RequestBody DepartmentDTO department,
                                         @PathVariable(name="idUpdate")Integer id)
    {   departmentService.update(department,id);
        return new ResponseEntity<>("update thanh cong",HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<Department> findbyName(@RequestParam(name="name") String name   ){
        Department department = departmentService.findByName(name);
        // neu doi tuong ko co gia tri gan luon gia null
        return new ResponseEntity<>(department,HttpStatus.OK);
    }
}
