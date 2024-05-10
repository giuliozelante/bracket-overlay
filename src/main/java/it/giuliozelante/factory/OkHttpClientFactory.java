package it.giuliozelante.factory;

import io.micronaut.context.annotation.Factory;
import it.giuliozelante.config.AuthorizationInterceptor;
import it.giuliozelante.config.GraphQLConfig;
import okhttp3.OkHttpClient;

@lombok.AllArgsConstructor
@Factory
public class OkHttpClientFactory {

    private final GraphQLConfig config;

    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new AuthorizationInterceptor(config.getToken()))
                .build();
    }

}
