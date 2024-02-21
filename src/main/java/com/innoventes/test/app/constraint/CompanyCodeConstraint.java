package com.innoventes.test.app.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Task 2 - Add Constraints to the Company DTO - For which I have made the annotation.
public class CompanyCodeConstraint implements ConstraintValidator<CompanyCode, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // Pattern I was not able to write in the given time.
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(s);
        try {
            if (!matcher.matches()) return false;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }
}
