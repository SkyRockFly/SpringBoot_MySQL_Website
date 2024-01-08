package com.skyrockfly.spring.security.security.service;

import com.skyrockfly.spring.security.security.dto.ProtossUnitDto;

import java.util.List;

public interface ProtossUnitService {
    void saveUnit(ProtossUnitDto unitDto, String username);

    List<ProtossUnitDto> findAllByUserId(int it);
}
