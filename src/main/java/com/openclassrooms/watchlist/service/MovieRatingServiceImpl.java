package com.openclassrooms.watchlist.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.openclassrooms.watchlist.controller.WatchlistController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@ConditionalOnProperty(name = "app.environment", havingValue = "prod")
public class MovieRatingServiceImpl implements MovieRatingService {

    private final Logger LOGGER = LoggerFactory.getLogger(MovieRatingServiceImpl.class);
    private String apiUrl = "http://www.omdbapi.com/?apikey=e9f94c34&t=";


    public MovieRatingServiceImpl() {
    }

    @Override
    public String getMovieRating(String title) {

        try {
            RestTemplate template = new RestTemplate();

            LOGGER.info("OMDb API called with URL : {}",apiUrl+title);
            ResponseEntity<ObjectNode> response = template.getForEntity(apiUrl + title, ObjectNode.class);

            ObjectNode jsonObject = response.getBody();

            LOGGER.debug("OMDb API response : {}", jsonObject);
            return jsonObject.path("imdbRating").asText();
        } catch (Exception e) {
            System.out.println("Something went wrong while calling OMDb API " + e.getMessage());
            LOGGER.warn("Something went wrong while calling OMDb API" + e.getMessage());
            return null;
        }
    }

}
