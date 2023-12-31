package com.jessejputnam.movieAPI.Model;

import java.util.UUID;
import java.util.HashSet;
import java.util.List;

public class Video {
    private String id;
    private int apiId;
    private String title;
    private String releaseDate;
    private String overview;
    private String imgSmall;
    private String imgLarge;
    private double voteAverage;
    private double userRating;
    private double popularity;
    private List<Genre> genres;
    private int listId;

    /**
     * Constructor for new video to push to DB
     * 
     * @param apiId       - int
     * @param title       - String
     * @param releaseDate - String
     * @param overview    - String
     * @param imgSmall    - String
     * @param imgLarge    - String
     * @param voteAverage - double
     * @param userRating  - double
     * @param popularity  - double
     * @param genres      - List<Genre>
     * @param listId      - int
     */
    public Video(int apiId, String title, String releaseDate, String overview, String imgSmall, String imgLarge,
            double voteAverage, double userRating, double popularity, List<Genre> genres, int listId) {
        id = UUID.randomUUID().toString();
        this.apiId = apiId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.imgSmall = imgSmall;
        this.imgLarge = imgLarge;
        this.voteAverage = voteAverage;
        this.userRating = userRating;
        this.popularity = popularity;
        this.genres = genres;
        this.listId = listId;
    }

    /**
     * Constructor for existing account from DB with all fields
     * 
     * @param id          - String
     * @param apiId       - int
     * @param title       - String
     * @param releaseDate - String
     * @param overview    - String
     * @param imgSmall    - String
     * @param imgLarge    - String
     * @param voteAverage - double
     * @param userRating  - double
     * @param popularity  - double
     * @param genres      - List<Integer>
     * @param listId      - String
     */
    public Video(String id, int apiId, String title, String releaseDate, String overview, String imgSmall,
            String imgLarge,
            double voteAverage, double userRating, double popularity, List<Genre> genres, int listId) {
        this.id = id;
        this.apiId = apiId;
        this.imgSmall = imgSmall;
        this.imgLarge = imgLarge;
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.userRating = userRating;
        this.popularity = popularity;
        this.genres = genres;
        this.listId = listId;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        id = UUID.randomUUID().toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getImgSmall() {
        return imgSmall;
    }

    public void setImgSmall(String imgSmall) {
        this.imgSmall = imgSmall;
    }

    public String getImgLarge() {
        return imgLarge;
    }

    public void setImgLarge(String imgLarge) {
        this.imgLarge = imgLarge;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    /**
     * Add single genre to genres list
     * 
     * @param genre
     */
    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    /**
     * Removes specific genre from genres list by genreId
     * 
     * @param genreId
     */
    public void removeGenre(int genreId) {
        int idx = -1;
        for (int i = 0; i < genres.size(); i++)
            if (genres.get(i).getId() == genreId)
                idx = i;

        if (idx > -1)
            genres.remove(idx);
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    /**
     * Check if the Video has the all the same genres as with another video and no
     * extra or different genres
     * 
     * @param genres
     * @return
     */
    public boolean hasSameGenres(List<Genre> genres) {
        HashSet<Integer> set = new HashSet<>();
        for (Genre genre : this.genres)
            set.add(genre.getId());

        if (set.size() != genres.size())
            return false;

        for (Genre genre : genres)
            if (!set.contains(genre.getId()))
                return false;

        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Video vid = (Video) obj;
        return vid.getId().equals(id) && vid.getApiId() == apiId && vid.getImgSmall().equals(imgSmall)
                && vid.getImgLarge().equals(imgLarge) && vid.getTitle().equals(title)
                && vid.getOverview().equals(overview) && vid.getReleaseDate().equals(releaseDate)
                && vid.getVoteAverage() == voteAverage && vid.getUserRating() == userRating
                && vid.getPopularity() == popularity
                && vid.hasSameGenres(genres)
                && vid.getListId() == listId;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        int result = 1;
        result = prime * result + (id != null ? id.hashCode() : 0);
        result = prime * result + apiId;
        result = prime * result + (imgSmall != null ? imgSmall.hashCode() : 0);
        result = prime * result + (imgLarge != null ? imgLarge.hashCode() : 0);
        result = prime * result + (title != null ? title.hashCode() : 0);
        result = prime * result + (overview != null ? overview.hashCode() : 0);
        result = prime * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        long temp = Double.doubleToLongBits(voteAverage);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(userRating);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(popularity);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + listId;
        for (Genre genre : genres)
            result = result + genre.getId();
        return result;
    }

    @Override
    public String toString() {
        return "Video{id: " + id + ", apiId: " + apiId + ", title: " + title + ", releaseDate: " + releaseDate
                + ", overview: " + overview + ", imgSmall: " + imgSmall + ", imgLarge: " + imgLarge + ", voteAverage: "
                + voteAverage + ", userRating: " + userRating + ", popularity: " + popularity + ", listId: " + listId
                + "}";
    }
}
