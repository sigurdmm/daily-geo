package com.sigurd.geoguessr.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static com.sigurd.geoguessr.model.GeoguessrV3ApiModels.GameScores;

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
}
