package com.vti.Service;

import com.vti.enitity.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
    Position findId(Integer id);
    void cretePosition(String name);
    void UpdatePosition(String updateName,Integer id);
}
