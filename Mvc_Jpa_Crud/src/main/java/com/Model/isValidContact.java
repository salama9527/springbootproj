package com.Model;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
@NotBlank
@Documented
@Constraint(validatedBy=ContactValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface isValidContact {
	String message() default "*Invalid phone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
