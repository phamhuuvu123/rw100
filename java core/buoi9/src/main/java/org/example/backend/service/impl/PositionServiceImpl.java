package org.example.backend.service.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.IPositionRepository;
import org.example.backend.repository.impl.PositionRepositoryImpl;
import org.example.backend.service.IPositionservice;
import org.example.entity.Position;
import org.example.backend.repository.IPositionRepository;
import java.util.List;

public class PositionServiceImpl implements IPositionRepository, IPositionservice {
    private IPositionRepository positionRepository = new PositionRepositoryImpl();

    @Override
    public List<Position> findAll() {
            List<Position> positions =  positionRepository.findAll();
        return positions    ;
    }

    @Override
    public boolean createPosition(String name) {
       boolean check = positionRepository.createPosition(name);
       return check;
    }


    @Override
    public boolean deletePosition(int id) {
        boolean check =positionRepository.deletePosition(id);
        return check;
    }

    @Override
    public boolean updatePosition(int id, String name) {
        boolean check =positionRepository.updatePosition(id,name);
        return check;
    }

    @Override
    public List<Position> findById(int id) {
        List<Position> positions =  positionRepository.findById(id);
        return positions    ;
    }


}
