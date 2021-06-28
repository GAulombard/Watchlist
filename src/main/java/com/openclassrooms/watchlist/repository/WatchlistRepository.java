package com.openclassrooms.watchlist.repository;

import com.openclassrooms.watchlist.domain.WatchlistItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Watchlist repository.
 */

public class WatchlistRepository {

    private List<WatchlistItem> watchlistItems = new ArrayList<>();
    private static Integer index = 1;

    /**
     * Gets list.
     *
     * @return the list
     */
    public List<WatchlistItem> getList() {
        return watchlistItems;
    }

    /**
     * Add item.
     *
     * @param watchlistItem the watchlist item
     */
    public void addItem(WatchlistItem watchlistItem) {
        watchlistItem.setId(index++);
        watchlistItems.add(watchlistItem);
    }

    /**
     * Find by id watchlist item.
     *
     * @param id the id
     * @return the watchlist item
     */
    public WatchlistItem findById(Integer id) {
        for (WatchlistItem watchlistItem : watchlistItems) {
            if (watchlistItem.getId().equals(id))
                return watchlistItem;
        }
        return null;
    }

    /**
     * Find by title watchlist item.
     *
     * @param title the title
     * @return the watchlist item
     */
    public WatchlistItem findByTitle(String title) {
        for (WatchlistItem watchlistItem : watchlistItems) {
            if (watchlistItem.getTitle().equals(title))
                return watchlistItem;
        }
        return null;
    }
}
