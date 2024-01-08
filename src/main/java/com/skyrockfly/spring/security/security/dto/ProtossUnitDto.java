package com.skyrockfly.spring.security.security.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class ProtossUnitDto {

    private int id;

    @NotEmpty
    private String type;

    private Map<@NotEmpty String, @Min(0) @Max(3) Integer> upgrades;

    private int userId;

    private String[] types = {"Reaver", "Dragoon", "Zealot"};

    public ProtossUnitDto() {
        upgrades = new HashMap<>();

        upgrades.put("Attack", 0);
        upgrades.put("Shield", 0);
        upgrades.put("Armor", 0);

    }
}
