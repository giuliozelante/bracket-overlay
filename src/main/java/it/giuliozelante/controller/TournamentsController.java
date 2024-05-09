package it.giuliozelante.controller;

import java.util.HashMap;
import java.util.Map;

import org.thymeleaf.TemplateEngine;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.ApolloClient;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.views.View;
import it.giuliozelante.TournamentsByOwnerQuery;
import it.giuliozelante.factory.ApolloClientFactory;

@Controller("tournaments")
public class TournamentsController {
    private final ApolloClient apolloClient;
    private final TemplateEngine templateEngine;

    public TournamentsController(ApolloClientFactory apolloClientFactory, TemplateEngine templateEngine) {
        this.apolloClient = apolloClientFactory.apolloClient();
        this.templateEngine = templateEngine;
    }

    @Get("")
    @View("tournaments/home.html")
    @Produces(MediaType.TEXT_HTML)
    @ExecuteOn(TaskExecutors.BLOCKING)
    public Map<String, Object> findAll() {
        TournamentsByOwnerQuery query = TournamentsByOwnerQuery.builder().ownerId("1802421").perPage(500).build();
        Map<String, Object> initialHtml = new HashMap<>();
        apolloClient.query(query).enqueue(new ApolloCall.Callback<TournamentsByOwnerQuery.Data>() {
            @Override
            public void onResponse(Response<TournamentsByOwnerQuery.Data> response) {

                // Handle successful response
                TournamentsByOwnerQuery.Data data = response.getData(); // Access data directly from response
                initialHtml.put("data", data);

                data.tournaments().nodes().stream().forEach(tournament -> System.out.println(tournament.name()));
            }

            @Override
            public void onFailure(ApolloException e) {
            }
        });
        return initialHtml;
    }
}
