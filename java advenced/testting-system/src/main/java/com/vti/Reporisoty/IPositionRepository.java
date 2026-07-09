package com.vti.Reporisoty;

import com.vti.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position,Integer > {
    boolean existsByName(String name);
}
