package com.openclassrooms.watchlist.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@ConditionalOnProperty(name = "app.environment", havingValue = "dev")
public class MovieRatingServiceDummyImpl implements MovieRatingService{

    public MovieRatingServiceDummyImpl() {
    }

    @Override
    public String getMovieRating(String title) {
        return "9.99";
    }
}
