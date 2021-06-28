package com.openclassrooms.watchlist.service;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface MovieRatingService {
    String getMovieRating(String title);
}
