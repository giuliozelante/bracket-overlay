package it.giuliozelante.controller;

import java.util.HashMap;
import java.util.Map;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.views.View;

@Controller
public class HomeController {

    @View("index") // <5>
    @Get
    public Map<String, String> index() {
        return new HashMap<>();
    }
}
