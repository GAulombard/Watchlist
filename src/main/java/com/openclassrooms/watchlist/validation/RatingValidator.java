package com.openclassrooms.watchlist.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The type Rating validator.
 */
public class RatingValidator implements ConstraintValidator<Rating, String> {
    public void initialize(Rating constraint) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        Double number;
        try {
            number = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }

        if (number > 10 || number < 1) {
            return false;
        }

        return true;
    }
}
