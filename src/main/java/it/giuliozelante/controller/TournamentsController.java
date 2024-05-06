package it.giuliozelante.controller;

import com.apollographql.apollo.ApolloClient;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("tournaments")
public class TournamentsController {

    @Inject
    private ApolloClient apolloClient;

    @Get("")
    public String findAll(String query) {
        return "";
    }
}
