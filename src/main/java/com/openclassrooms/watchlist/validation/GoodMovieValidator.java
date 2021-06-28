package com.openclassrooms.watchlist.validation;

import com.openclassrooms.watchlist.domain.WatchlistItem;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The type Good movie validator.
 */
public class GoodMovieValidator implements ConstraintValidator<GoodMovie, WatchlistItem> {
    public void initialize(GoodMovie constraint) {
    }

    @Override
    public boolean isValid(WatchlistItem value, ConstraintValidatorContext context) {

        return !(Double.valueOf(value.getRating()) >= 8 && "L".equals(value.getPriority()));
    }
}
