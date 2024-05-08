package it.giuliozelante.controller;

import java.util.Collections;
import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import it.giuliozelante.TournamentsByOwnerQuery;

@Controller("tournaments")
public class TournamentsController {

    private final ApolloClient apolloClient;
    private final TemplateEngine templateEngine;

    public TournamentsController(ApolloClient apolloClient, TemplateEngine templateEngine) {
        this.apolloClient = apolloClient;
        this.templateEngine = templateEngine;
    }

    @Get("")
    public String findAll() {
        TournamentsByOwnerQuery query = TournamentsByOwnerQuery.builder().ownerId("1802421").perPage(500).build();
        Map<String, Object> data = Collections.emptyMap();
        Context context = new Context();
        context.setVariables(data);
        String initialHtml = templateEngine.process("tournaments/home.html", context);
        apolloClient.query(query).enqueue(new ApolloCall.Callback<TournamentsByOwnerQuery.Data>() {
            @Override
            public void onResponse(Response<TournamentsByOwnerQuery.Data> response) {
                // Handle successful response
                TournamentsByOwnerQuery.Data data = response.getData(); // Access data directly from response
                data.tournaments().nodes().stream().forEach(tournament -> System.out.println(tournament.name()));
            }

            @Override
            public void onFailure(ApolloException e) {
            }
        });
        return initialHtml;
    }
}
