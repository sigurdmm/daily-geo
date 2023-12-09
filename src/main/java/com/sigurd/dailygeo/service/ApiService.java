package com.sigurd.dailygeo.service;

import com.sigurd.dailygeo.model.GameSettings;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static com.sigurd.dailygeo.model.GeoguessrV3ApiModels.GameScores;

@Service
public class ApiService {
    private final RestClient restClient;

    public ApiService(RestClient restClient) {
        this.restClient = restClient;
    }

    public GameScores getScoresFromGameId(String gameId, int limit) {
        return restClient.get()
                .uri("results/highscores/{gameId}?limit={limit}", gameId, limit)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(GameScores.class);
    }

    public String getChallengeToken(GameSettings gameSettings) {
        record Response(String token) {}
        return restClient.post()
                .uri("/challenges")
                .body(gameSettings)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(Response.class)
                .token;
    }
}
