package it.giuliozelante.controller;

import java.io.IOException;
import java.util.Map;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.json.tree.JsonNode;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.serde.ObjectMapper;
import io.micronaut.views.View;
import it.giuliozelante.TournamentsByOwnerQuery;
import it.giuliozelante.config.GraphQLConfig;
import it.giuliozelante.factory.OkHttpClientFactory;
import it.giuliozelante.model.tournament.TournamentsRequest;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Controller("tournaments")
public class TournamentsController {
    private final OkHttpClient okHttpClient;
    // private final TemplateEngine templateEngine;
    private final GraphQLConfig config;
    private final ObjectMapper mapper;

    public TournamentsController(OkHttpClientFactory okHttpClientFactory,
            GraphQLConfig graphQLConfig, ObjectMapper mapper) {
        this.okHttpClient = okHttpClientFactory.okHttpClient();
        // this.templateEngine = templateEngine;
        this.config = graphQLConfig;
        this.mapper = mapper;
    }

    @Get("")
    @View("tournaments/home.html")
    @Produces(MediaType.TEXT_HTML)
    @ExecuteOn(TaskExecutors.BLOCKING)
    public Map<String, Object> findAll() {
        TournamentsByOwnerQuery query = TournamentsByOwnerQuery.builder().ownerId("1802421").perPage(500).build();
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
                JsonNode node = mapper.readValue(response.body().string(), JsonNode.class);

                return Map.of("tournaments", node.get("tournaments").get(1).get("nodes"));
            } else {
                throw new RuntimeException("Failed to fetch data from GraphQL endpoint");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
