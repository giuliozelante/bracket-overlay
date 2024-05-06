package it.giuliozelante.factory;

import com.apollographql.apollo.ApolloClient;

import io.micronaut.context.annotation.Factory;
import it.giuliozelante.config.AuthorizationInterceptor;
import it.giuliozelante.config.GraphQLConfig;
import jakarta.inject.Inject;
import okhttp3.OkHttpClient;

@Factory
public class ApolloClientFactory {

    private final GraphQLConfig config;

    @Inject
    public ApolloClientFactory(GraphQLConfig config) {
        this.config = config;
    }

    public ApolloClient apolloClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AuthorizationInterceptor(config.getToken()))
                .build();

        return ApolloClient.builder()
                .serverUrl(config.getEndpoint())
                .okHttpClient(okHttpClient).build();
    }
}