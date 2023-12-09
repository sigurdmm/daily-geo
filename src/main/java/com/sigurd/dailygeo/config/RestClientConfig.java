package com.sigurd.dailygeo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${geoguessr.api.url}")
    private String apiUrl;

    @Value("${geoguessr.api.token}")
    private String apiToken;

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
            .baseUrl(apiUrl)
            .defaultHeader("Cookie", "_ncfa=" + apiToken)
            .build();
    }
}
