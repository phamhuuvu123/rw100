package com.vti.Service.impl;

import com.vti.Repository.IPositionRepository;
import com.vti.Repository.impl.PositionRepository;
import com.vti.Service.IPositionService;
import com.vti.enitity.Position;

import java.util.List;

public class PositionService implements IPositionService {
    private IPositionRepository iPositionRepository = new PositionRepository();
    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }

    @Override
    public Position findId(Integer id) {
        return iPositionRepository.findId(id);
    }

    @Override
    public void cretePosition(String name) {
    iPositionRepository.createPosition(name);
    }

    @Override
    public void UpdatePosition(String updateName, Integer id) {
    iPositionRepository.updatePosition(updateName,id);
    }
}
