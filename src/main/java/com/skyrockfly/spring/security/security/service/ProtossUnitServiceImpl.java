package com.skyrockfly.spring.security.security.service;

import com.skyrockfly.spring.security.security.dto.ProtossUnitDto;
import com.skyrockfly.spring.security.security.entity.ProtossUnit;
import com.skyrockfly.spring.security.security.repository.ProtossUnitRepository;
import com.skyrockfly.spring.security.security.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProtossUnitServiceImpl implements ProtossUnitService{

    ProtossUnitRepository unitRepository;

    UserRepository userRepository;

    public ProtossUnitServiceImpl(ProtossUnitRepository unitRepository, UserRepository userRepository) {
        this.unitRepository = unitRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveUnit(ProtossUnitDto unitDto, String username) {
        ProtossUnit unit = new ProtossUnit();
        unit.setType(unitDto.getType());
        unit.setUpgrades(unitDto.getUpgrades());
        unit.setUserId(userRepository.findByEmail(username).getId());
        unitRepository.save(unit);

    }

    @Override
    public List<ProtossUnitDto> findAllByUserId(int id) {
        List<ProtossUnit> list = unitRepository.findAllByUserId(id);
        return list.stream().map(unit ->mapToUnitDto(unit))
                .collect(Collectors.toList());
    }

    private ProtossUnitDto mapToUnitDto(ProtossUnit unit){
        ProtossUnitDto unitDto = new ProtossUnitDto();
        unitDto.setId(unit.getId());
        unitDto.setType(unit.getType());
        unitDto.setUserId(unit.getUserId());
        unitDto.setUpgrades(unit.getUpgrades());
        return unitDto;
    }
}
