package it.giuliozelante.config;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("graphql") // Matches "graphql." prefix in properties
public interface GraphQLConfig {
    String getEndpoint();

    void setEndpoint(String endpoint);

    String getToken();

    void setToken(String token);
}