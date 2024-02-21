package com.innoventes.test.app.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EvenOrZeroConstraint implements ConstraintValidator<EvenNumberOrZero, Integer> {
    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        return s == 0 || s % 2 == 0;
    }
}
