package it.giuliozelante.controller;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.views.View;
import it.giuliozelante.PhaseGroupSetsQuery;
import it.giuliozelante.TournamentsByOwnerQuery;
import it.giuliozelante.config.GraphQLConfig;
import it.giuliozelante.factory.OkHttpClientFactory;
import it.giuliozelante.model.tournaments.TournamentsByOwnerResponse;
import it.giuliozelante.model.tournaments.TournamentsRequest;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Controller("tournaments")
public class BracketsController {
    private static class GraphQLEndpointException extends RuntimeException {
        public GraphQLEndpointException(String message) {
            super(message);
        }
    }

    private static class GraphQLIOException extends RuntimeException {
        public GraphQLIOException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    private final OkHttpClient okHttpClient;

    private final GraphQLConfig config;

    private final ObjectMapper mapper;

    public BracketsController(OkHttpClientFactory okHttpClientFactory,
            GraphQLConfig graphQLConfig, ObjectMapper mapper) {
        this.okHttpClient = okHttpClientFactory.okHttpClient();
        this.config = graphQLConfig;
        this.mapper = mapper;
    }

    @Get("{eventId}")
    @View("brackets/bracket.html")
    @Produces(MediaType.TEXT_HTML)
    @ExecuteOn(TaskExecutors.BLOCKING)
    public Map<String, Object> getBracket(Long eventId) {
        PhaseGroupSetsQuery query = PhaseGroupSetsQuery.builder().phaseGroupId()ownerId("1802421").perPage(500).build();
        TournamentsRequest tr = new TournamentsRequest(500, 1802421L);
        Map<String, Object> bodyMap = Map.of("query", query.queryDocument().toString(), "variables", tr);

        RequestBody body;
        try {
            body = RequestBody.create(okhttp3.MediaType.parse("application/json"),
                    mapper.writeValueAsString(bodyMap));

            Request request = new Request.Builder()
                    .url(config.getEndpoint())
                    .post(body)
                    .addHeader("Content-Type", MediaType.APPLICATION_JSON)
                    .build();

            Call call = this.okHttpClient.newCall(request);
            Response response = call.execute();

            if (response.isSuccessful()) {
                String responseString = response.body().string();
                TournamentsByOwnerResponse tournaments = mapper.readValue(responseString,
                        TournamentsByOwnerResponse.class);

                return Map.of("tournaments", tournaments.getData().getTournaments().getNodes());
            } else {
                throw new GraphQLEndpointException("Failed to fetch data from GraphQL endpoint");
            }
        } catch (IOException e) {
            throw new GraphQLIOException("Error communicating with GraphQL endpoint", e);
        }
    }
}