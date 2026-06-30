package com.vti.Controller;

import com.vti.Service.IPositionService;
import com.vti.Service.impl.PositionService;
import com.vti.enitity.Position;

import java.util.List;

public class PositionController {
    private IPositionService iPositionService = new PositionService();
    public List<Position> findAll() {
        return iPositionService.findAll();
    }
    public Position findId(Integer id) {
        return iPositionService.findId(id);
    }
    public void cretePosition(String name) {
      iPositionService.cretePosition(name);
    }
    public void UpdatePosition(String updateName, Integer id) {
        iPositionService.UpdatePosition(updateName,id);
    }
}
