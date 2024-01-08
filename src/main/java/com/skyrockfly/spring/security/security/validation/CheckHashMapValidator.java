package com.skyrockfly.spring.security.security.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Map;

public class CheckHashMapValidator implements ConstraintValidator<CheckHashMap, Map<String,Integer>> {
    private int min,max;

    @Override
    public void initialize(CheckHashMap values) {
        min = values.min();
        max = values.max();
    }

    @Override
    public boolean isValid(Map<String, Integer> upgrades, ConstraintValidatorContext constraintValidatorContext) {
        for(Map.Entry<String,Integer> entry: upgrades.entrySet()){
            if(entry.getValue() < 0 || entry.getValue() > 3 ) {
                return false;
            }
        }

        return true;

    }
}
