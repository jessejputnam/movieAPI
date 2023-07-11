package com.jessejputnam.movieAPI;

import com.jessejputnam.movieAPI.Controller.APIController;

import io.javalin.Javalin;

/**
 * MOVIE-API -- API for accessing Film and TV data from
 * The Movie Database API [https://www.themoviedb.org/]
 * and saving movies to personal lists
 *
 */
public class App {
    public static void main(String[] args) {
        APIController controller = new APIController();
        Javalin app = controller.startAPI();
        app.start(8080);
    }
}
