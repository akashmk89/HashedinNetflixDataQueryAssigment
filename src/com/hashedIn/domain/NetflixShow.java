package com.hashedIn.domain;
import java.util.Date;
import java.util.Set;

public class NetflixShow {
    private String showId;
    private String type;
    private String title;
    private Set<String> directors;
    private Set<String> casts;
    private Set<String> countries;
    private Date dateAdded;
    private int releaseYear;
    private String rating;
    private String duration;
    private Set<String> genres;
    private String description;

    //All Argument Constructor
    public NetflixShow(String showId, String type, String title, Set<String> directors, Set<String> casts, Set<String> countries, Date dateAdded, int releaseYear, String rating, String duration, Set<String> genres, String description) {
        this.showId = showId;
        this.type = type;
        this.title = title;
        this.directors = directors;
        this.casts = casts;
        this.countries = countries;
        this.dateAdded = dateAdded;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.genres = genres;
        this.description = description;
    }


    public Set<String> getCountries() {
        return countries;
    }

    public void setCountries(Set<String> countries) {
        this.countries = countries;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public String getShowId() {
        return showId;
    }
    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<String> directors) {
        this.directors = directors;
    }

    public Set<String> getCasts() {
        return casts;
    }

    public void setCasts(Set<String> casts) {
        this.casts = casts;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setRelease_year(Integer release_year) {
        this.releaseYear = release_year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NetflixMovies{" +
                "show_id='" + showId + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", directors='" + directors + '\'' +
                ", casts='" + casts + '\'' +
                ", countries='" + countries + '\'' +
                ", dateAdded=" + dateAdded +
                ", releaseYear=" + releaseYear +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", genres='" + genres + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}

