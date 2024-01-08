package com.skyrockfly.spring.security.security.service;

import com.skyrockfly.spring.security.security.dto.ProtossUnitDto;
import com.skyrockfly.spring.security.security.entity.ProtossUnit;

import java.util.List;

public interface ProtossUnitService {
    void saveUnit(ProtossUnitDto unitDto, String username);

    ProtossUnitDto findById(int id);
    List<ProtossUnitDto> findByType(String type);

    List<ProtossUnitDto> findAllByUserId(int it);
}
