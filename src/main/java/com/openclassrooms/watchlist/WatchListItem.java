package com.openclassrooms.watchlist;

/**
 * The type Watch list item.
 */
public class WatchListItem {

    private String title;
    private String rating;
    private String priority;
    private String comment;
    private int id;

    /**
     * Instantiates a new Watch list item.
     *
     * @param title    the title
     * @param rating   the rating
     * @param priority the priority
     * @param comment  the comment
     * @param id       the id
     */
    public WatchListItem(String title, String rating, String priority, String comment, int id) {
        this.title = title;
        this.rating = rating;
        this.priority = priority;
        this.comment = comment;
        this.id = id;
    }

    public WatchListItem() {

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
    public int getId() {
        return this.id;
    }

    /**
     * set field
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }
}
