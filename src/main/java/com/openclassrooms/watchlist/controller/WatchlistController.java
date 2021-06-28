package com.openclassrooms.watchlist.controller;

import com.openclassrooms.watchlist.domain.WatchlistItem;
import com.openclassrooms.watchlist.exception.DuplicateTitleException;
import com.openclassrooms.watchlist.service.WatchlistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Watchlist controller.
 */
@Controller
public class WatchlistController {

    private final Logger LOGGER = LoggerFactory.getLogger(WatchlistController.class);
    private WatchlistService watchlistService;

    @Autowired
    public WatchlistController(WatchlistService watchlistService) {
        super();
        this.watchlistService = watchlistService;
    }

    /**
     * Show watchlist item form model and view.
     *
     * @param id the id
     * @return the model and view
     */
    @GetMapping("/watchlistItemForm")
    public ModelAndView showWatchlistItemForm(@RequestParam(required = false) Integer id) {

        LOGGER.info("HTTP GET request received at /watchlistItemForm");

        Map<String, Object> model = new HashMap<>();

        WatchlistItem watchlistItem = watchlistService.findWatchlistItemsById(id);

        if (watchlistItem == null) {
            model.put("watchlistItem", new WatchlistItem());
        } else {
            model.put("watchlistItem", watchlistItem);
        }
        return new ModelAndView("watchlistItemForm", model);
    }

    /**
     * Submit watchlist item form model and view.
     *
     * @param watchlistItem the watchlist item
     * @param bindingResult the binding result
     * @return the model and view
     */
    @PostMapping("/watchlistItemForm")
    public ModelAndView submitWatchlistItemForm(@Valid WatchlistItem watchlistItem, BindingResult bindingResult) {

        LOGGER.info("HTTP POST request received at /watchlistItemForm");

        if (bindingResult.hasErrors()) {
            return new ModelAndView("watchlistItemForm");
        }

        try {
            watchlistService.addOrUpdateWatchlistItem(watchlistItem);
        } catch (DuplicateTitleException e) {
            bindingResult.rejectValue("title", "", "This movie is already on your watchlist");
            return new ModelAndView("watchlistItemForm");
        }


        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/watchlist");

        return new ModelAndView(redirectView);
    }

    /**
     * Gets watchlist.
     *
     * @return the watchlist
     */
    @GetMapping("/watchlist")
    public ModelAndView getWatchlist() {

        LOGGER.info("HTTP GET request received at /watchlist");

        String viewName = "watchlist";

        Map<String, Object> model = new HashMap<String, Object>();

        model.put("watchlistItems", watchlistService.getWatchlistItems());
        model.put("numberOfMovies", watchlistService.getWatchlistItemsSize());

        return new ModelAndView(viewName, model);
    }
}
