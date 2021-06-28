package com.openclassrooms.watchlist.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The type Priority validator.
 */
public class PriorityValidator implements ConstraintValidator<Priority, String> {


    public void initialize(Priority constraint) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return value.trim().length() == 1 && "LHM".contains(value.toUpperCase());
    }
}
