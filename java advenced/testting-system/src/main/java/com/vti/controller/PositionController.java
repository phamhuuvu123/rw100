package com.vti.controller;

import com.vti.dto.PositionDTO;
import com.vti.entity.Position;
import com.vti.form.PositionCreateOrUpdateForm;
import com.vti.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/positions")
@CrossOrigin("*")
public class PositionController {
    @Autowired
    private IPositionService positionService;
    @GetMapping
    public ResponseEntity<List<PositionDTO>> findAll()
    {
        List<PositionDTO> positions = positionService.findAll();
        return new ResponseEntity<>(positions,HttpStatus.OK);
    }
    @GetMapping("/{idPosition}")
    public ResponseEntity<PositionDTO> findById(@PathVariable (name = "idPosition")Integer id)
    {
        PositionDTO positionDTO= positionService.findById(id);
        return new ResponseEntity<>(positionDTO,HttpStatus.OK);
    }
    @PostMapping
    public  ResponseEntity<String> create(@RequestBody PositionCreateOrUpdateForm position)
    {
        positionService.create(position);
        return new ResponseEntity<>("tao moi thanh cong",HttpStatus.OK);
    }
    @DeleteMapping("/{idPosDelete}")
    public ResponseEntity<String> Delete(@PathVariable(name = "idPosDelete")Integer id)
    {
        positionService.deleteByid(id);
        return new ResponseEntity<>("xoa thanh cong",HttpStatus.OK);
    }
    @PutMapping("/{idUpPos}")
    public ResponseEntity<String> Update(@RequestBody PositionDTO positionDTO ,
                                         @PathVariable(name = "idUpPos")Integer id)
    {
        positionService.update(positionDTO,id);
        return new ResponseEntity<>("update thanh cong",HttpStatus.OK);
    }
}
