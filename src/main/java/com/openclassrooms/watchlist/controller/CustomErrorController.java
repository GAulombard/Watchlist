package com.openclassrooms.watchlist.controller;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * The type Custom error controller.
 */
@Controller
public class CustomErrorController implements ErrorController {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomErrorController.class);
    /**
     * Gets error path.
     *
     * @return the error path
     */
    public String getErrorPath() {
        return "/error";
    }

    /**
     * Handle error model and view.
     *
     * @param response the response
     * @return the model and view
     */
    @GetMapping("/error")
    public ModelAndView handleError(HttpServletResponse response) {
        int code = response.getStatus();
        if (code == 404) {
            LOGGER.error("Error with code {} happened.",code);
            System.out.println("Error with code "+code+" happened.");
            return new ModelAndView("error404");
        }
        LOGGER.error("Error with code {} happened.",code);
        System.out.println("Error with code "+code+" happened.");
        return new ModelAndView("error");
    }

}
