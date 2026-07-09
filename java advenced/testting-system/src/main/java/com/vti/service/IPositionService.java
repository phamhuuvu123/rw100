package com.vti.service;

import com.vti.dto.PositionDTO;
import com.vti.entity.Position;
import com.vti.form.PositionCreateOrUpdateForm;

import java.util.List;

public interface IPositionService {
    List<PositionDTO> findAll();
    PositionDTO findById(Integer id);

    void create(PositionCreateOrUpdateForm position);

    void deleteByid(Integer id);

    void update(PositionDTO positionDTO, Integer id);
}
