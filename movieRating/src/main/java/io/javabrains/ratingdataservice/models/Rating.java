package io.javabrains.ratingdataservice.models;

public class Rating {
    private String MovieId;
    private int rating;



    public Rating( String movieId,int rating) {
        this.rating = rating;
        MovieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMovieId() {
        return MovieId;
    }

    public void setMovieId(String movieId) {
        MovieId = movieId;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "rating=" + rating +
                ", MovieId='" + MovieId + '\'' +
                '}';
    }
}
