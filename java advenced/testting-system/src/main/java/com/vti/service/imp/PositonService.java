package com.vti.service.imp;

import com.vti.Reporisoty.IPositionRepository;
import com.vti.dto.PositionDTO;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.positionName;
import com.vti.form.PositionCreateOrUpdateForm;
import com.vti.service.IPositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PositonService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<PositionDTO> findAll() {
        List<Position> positionslist = positionRepository.findAll();
       List<PositionDTO> positiondto = new ArrayList<>();
        for(Position position:positionslist)
        {
            PositionDTO DTO=  modelMapper.map(position, PositionDTO.class);
            positiondto.add(DTO);
        }
        return positiondto;
    }

    @Override
    public PositionDTO findById(Integer id) {
        Position position= positionRepository.findById(id).orElse(null);
        PositionDTO dto = null;
        if(Objects.nonNull(position))
        {
            dto=modelMapper.map(position, PositionDTO.class);
        }
        return dto;
    }

    @Override
    public void create(PositionCreateOrUpdateForm position) {
        boolean check = positionRepository.existsByName(position.getName());
        if(check=true)
        {
            throw new RuntimeException("posion đã tồn tại");
        }
        Position pos = new Position();
        pos.setName(positionName.valueOf(position.getName()));
        positionRepository.save(pos);
    }

    @Override
    public void deleteByid(Integer id) {
        positionRepository.deleteById(id);
    }

    @Override
    public void update(PositionDTO positionDTO, Integer id) {
        boolean check = positionRepository.existsByName(positionDTO.getName());
        if(check=true)
        {
            throw new RuntimeException("posion đã tồn tại");
        }
        Position pos = new Position();
        pos.setName(positionName.valueOf(positionDTO.getName()));
        positionRepository.save(pos);
    }
}
