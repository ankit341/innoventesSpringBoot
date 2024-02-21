package com.innoventes.test.app.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompanyCodeConstraint.class)
@Documented
public @interface CompanyCode {
    String message() default "{Company Code Invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
