package org.example.backend.controller;

import org.example.backend.service.IPositionservice;
import org.example.backend.service.impl.PositionServiceImpl;
import org.example.entity.Position;

import java.util.List;

public class Positioncontroller {
    private IPositionservice positionservice= new PositionServiceImpl();
    public List<Position> findAll()
    {
        List<Position> positions =new PositionServiceImpl().findAll();
        return positions;
    }
    public boolean createPosition(String name)
    {
        boolean check= positionservice.createPosition(name);
        return check;
    }
    public  boolean updatePosition(int id, String name)
    {
        boolean check =positionservice.updatePosition(id,name);
        return check;
    }
    public boolean deletePosition(int id)
    {
        boolean check= positionservice.deletePosition(id);
        return check;
    }
    public List<Position> findById(int id)
    {
        List<Position> positions =new PositionServiceImpl().findById(id);
        return positions;
    }
}
