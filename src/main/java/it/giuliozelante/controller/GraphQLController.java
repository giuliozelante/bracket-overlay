package it.giuliozelante.controller;

import com.apollographql.apollo.ApolloClient;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller("/graphql")
public class GraphQLController {

    @Inject
    private ApolloClient apolloClient;

    @Get("/graphql")
    public String graphql(String query) {
        // Get the actual query string from request parameter
        Observable<QueryResponse<MyQuery.Data>> observable = apolloClient.query(actualQuery);
        // Perform operations on the Observable (optional)

        // Prepare data for Thymeleaf template (assuming String return type for
        // simplicity)
        String data = processResponseData(observable);
        return "myTemplate"; // Replace with your Thymeleaf template name
    }

    // Method to process the Observable response and return data for the template
    private String processResponseData(Observable<QueryResponse<MyQuery.Data>> observable) {
        // Implement logic to extract data from the response and format it for the
        // template
    }
}
