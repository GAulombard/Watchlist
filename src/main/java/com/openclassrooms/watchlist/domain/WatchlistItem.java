package com.openclassrooms.watchlist.domain;

import com.openclassrooms.watchlist.validation.GoodMovie;
import com.openclassrooms.watchlist.validation.Priority;
import com.openclassrooms.watchlist.validation.Rating;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * The type Watch list item.
 */
@GoodMovie
public class WatchlistItem {

    @NotBlank(message="Please enter the title")
    private String title;
    @Rating
    private String rating;
    @Priority
    private String priority;
    @Size(max=50, message = "Comment should be maximum 50 characters")
    private String comment;
    private Integer id;

    /**
     * Instantiates a new Watch list item.
     *
     * @param title    the title
     * @param rating   the rating
     * @param priority the priority
     * @param comment  the comment
     * @param id       the id
     */
    public WatchlistItem(String title, String rating, String priority, String comment, Integer id) {
        this.title = title;
        this.rating = rating;
        this.priority = priority;
        this.comment = comment;
        this.id = id;
    }

    /**
     * Instantiates a new Watchlist item.
     */
    public WatchlistItem() {

    }


    /**
     * get field
     *
     * @return title title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * set field
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * get field
     *
     * @return rating rating
     */
    public String getRating() {
        return this.rating;
    }

    /**
     * set field
     *
     * @param rating the rating
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * get field
     *
     * @return priority priority
     */
    public String getPriority() {
        return this.priority;
    }

    /**
     * set field
     *
     * @param priority the priority
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * get field
     *
     * @return comment comment
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * set field
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * get field
     *
     * @return id id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * set field
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }
}
