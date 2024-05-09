package it.giuliozelante.controller;

import java.util.Map;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

@Controller
public class HomeController {

    private TournamentsController tournamentsController;

    public HomeController(final TournamentsController tournamentsController) {
        this.tournamentsController = tournamentsController;
    }

    @View("index")
    @Get
    public Map<String, Object> index() {
        return this.tournamentsController.findAll();
    }
}
