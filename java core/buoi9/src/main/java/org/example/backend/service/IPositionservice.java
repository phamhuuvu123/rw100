package org.example.backend.service;

import org.example.entity.Position;

import java.util.List;

public interface IPositionservice {
    List<Position> findAll();
    boolean createPosition(String name);
    boolean deletePosition(int id);
    boolean updatePosition(int id,String name);
   List<Position> findById(int id);
}
