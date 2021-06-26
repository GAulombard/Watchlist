package com.openclassrooms.watchlist;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RatingValidator.class)
public @interface Rating {

    String message() default "please enter a number between 1-10 for rating";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}