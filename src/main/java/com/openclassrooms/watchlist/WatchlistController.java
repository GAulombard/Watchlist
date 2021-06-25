package com.openclassrooms.watchlist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WatchlistController {

    private List<WatchListItem> watchListItems = new ArrayList<>();
    private static int index = 1;

    @GetMapping("/watchlist")
    public ModelAndView getWatchList(){

        watchListItems.clear();
        watchListItems.add(new WatchListItem("Lion King","8.5","high","Hakuna Matata",index++));
        watchListItems.add(new WatchListItem("Frozen","7.5","medium","Let it go",index++));
        watchListItems.add(new WatchListItem("Cars","7.1","law","VROOM",index++));
        watchListItems.add(new WatchListItem("Wall-E","8.4","high","You are crying :-(",index++));
        watchListItems.add(new WatchListItem("Kung Pow","9","high","Niah niah",index++));

        String viewName = "watchlist";

        Map<String,Object> model = new HashMap<String,Object>();

        model.put("watchListItems",watchListItems);
        model.put("numberOfMovies",watchListItems.size());

        return new ModelAndView(viewName,model);
    }
}
