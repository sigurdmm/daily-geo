package com.sigurd.geoguessr.service;

import org.springframework.stereotype.Service;

import static com.sigurd.geoguessr.model.GeoguessrV3ApiModels.GameScores;

@Service
public class GameService {
    private final ApiService apiService;

    public GameService(ApiService apiService) {
        this.apiService = apiService;
    }

    public GameScores getScoresFromGameId(String gameId, int limit) {
        return apiService.getScoresFromGameId(gameId, limit);
    }
}
