package com.vti.Reporisoty;

import com.vti.entity.Position;
import com.vti.entity.positionName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Integer > {
    boolean existsByNameAndIdNot(String name,Integer id);
    boolean existsByName(positionName name);
}
