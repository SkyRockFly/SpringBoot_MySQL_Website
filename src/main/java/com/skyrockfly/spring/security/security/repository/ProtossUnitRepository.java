package com.skyrockfly.spring.security.security.repository;

import com.skyrockfly.spring.security.security.dto.ProtossUnitDto;
import com.skyrockfly.spring.security.security.entity.ProtossUnit;
import com.skyrockfly.spring.security.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProtossUnitRepository extends JpaRepository<ProtossUnit, Integer> {
    ProtossUnit findById(int id);
    List<ProtossUnit> findAllByType(String type);

    List<ProtossUnit> findAllByUserId(int id);
}
