package com.garnizon.pim.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = DateFormatValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFormatConstraint {
    
	String message() default "Invalid date format, expected {dateFormat}";
    String dateFormat() default "yyyy-MM-dd HH:mm:ss";
    
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}