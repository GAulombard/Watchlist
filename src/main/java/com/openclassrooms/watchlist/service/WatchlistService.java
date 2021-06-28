package com.openclassrooms.watchlist.service;

import com.openclassrooms.watchlist.domain.WatchlistItem;
import com.openclassrooms.watchlist.exception.DuplicateTitleException;
import com.openclassrooms.watchlist.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Watchlist service.
 */

public class WatchlistService {

    /**
     * The Watchlist repository.
     */
    WatchlistRepository watchlistRepository;

    MovieRatingService movieRatingService;


    public WatchlistService(WatchlistRepository watchlistRepository, MovieRatingService movieRatingService) {
        super();
        this.watchlistRepository = watchlistRepository;
        this.movieRatingService = movieRatingService;
    }

    /**
     * Gets watchlist items.
     *
     * @return the watchlist items
     */
    public List<WatchlistItem> getWatchlistItems() {
        List<WatchlistItem> watchlistItems = watchlistRepository.getList();

        for(WatchlistItem watchlistItem : watchlistItems) {
            String rating = movieRatingService.getMovieRating(watchlistItem.getTitle());
            if(rating != null) {
                watchlistItem.setRating(rating);
            }
        }

        return watchlistItems;
    }

    /**
     * Gets watchlist items size.
     *
     * @return the watchlist items size
     */
    public int getWatchlistItemsSize() {
        return watchlistRepository.getList().size();
    }

    /**
     * Find watchlist items by id watchlist item.
     *
     * @param id the id
     * @return the watchlist item
     */
    public WatchlistItem findWatchlistItemsById(Integer id) {
        return watchlistRepository.findById(id);
    }

    /**
     * Add or update watchlist item.
     *
     * @param watchlistItem the watchlist item
     * @throws DuplicateTitleException the duplicate title exception
     */
    public void addOrUpdateWatchlistItem(WatchlistItem watchlistItem) throws DuplicateTitleException {
        WatchlistItem existingItem = findWatchlistItemsById(watchlistItem.getId());

        if (existingItem == null) {
            if (watchlistRepository.findByTitle(watchlistItem.getTitle()) != null) {
                throw new DuplicateTitleException();
            }
            watchlistRepository.addItem(watchlistItem);
        } else {
            existingItem.setComment(watchlistItem.getComment());
            existingItem.setPriority(watchlistItem.getPriority());
            existingItem.setRating(watchlistItem.getRating());
            existingItem.setTitle(watchlistItem.getTitle());
        }

    }
}
