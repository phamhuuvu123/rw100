package com.vti.Reporisoty;

import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmenRepository extends JpaRepository<Department,Integer> {
    Department findByName(String name);
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Integer id);
}
