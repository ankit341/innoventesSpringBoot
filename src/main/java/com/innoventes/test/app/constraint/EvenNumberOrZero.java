package com.innoventes.test.app.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

// Task - 6 - Adding new annotations.
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EvenOrZeroConstraint.class)
@Documented
public @interface EvenNumberOrZero {
    String message() default "{Company strength invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
