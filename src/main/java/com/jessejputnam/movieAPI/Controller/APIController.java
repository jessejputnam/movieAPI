package com.jessejputnam.movieAPI.Controller;

import io.javalin.Javalin;

public class APIController {

    public APIController() {

    }

    public Javalin startAPI() {
        Javalin app = Javalin.create();
        return app;
    }
}
