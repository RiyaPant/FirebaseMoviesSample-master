package com.brillicaservices.gurjas.firebasemoviessample.movies;

public class MoviesModelView {
    public String title;
    public int releaseYear;
    public String description;

    public int rating;
    public int image;

    public MoviesModelView(String title, String description, int releaseYear, int rating, int image) {

        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.image = image;
    }

    public MoviesModelView() {

    }

    public int getImage() {
        return image;
    }



    public int getRating() {
        return rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
