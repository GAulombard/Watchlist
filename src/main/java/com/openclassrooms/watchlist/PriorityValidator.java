package com.openclassrooms.watchlist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Locale;

public class PriorityValidator implements ConstraintValidator<Priority, String> {


    public void initialize(Priority constraint) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return value.trim().length() == 1 && "LHM".contains(value.toUpperCase());
    }
}
