package com.vti.Repository;

import com.vti.enitity.Position;

import java.util.List;

public interface IPositionRepository {
    List<Position> findAll();
    Position findId(Integer id);
    void createPosition(String name);
    void updatePosition(String name, Integer id);
    void deletePosition(Integer id);
}
