package com.sigurd.dailygeo.service;

import com.sigurd.dailygeo.model.GameSettings;
import org.springframework.stereotype.Service;

import static com.sigurd.dailygeo.model.GeoguessrV3ApiModels.GameScores;

@Service
public class GameService {
    private final ApiService apiService;

    public GameService(ApiService apiService) {
        this.apiService = apiService;
    }

    public GameScores getScoresFromGameId(String gameId, int limit) {
        return apiService.getScoresFromGameId(gameId, limit);
    }

    public String getGameUrl(GameSettings gameSettings) {
        String token = apiService.getChallengeToken(gameSettings);
        return "https://www.geoguessr.com/challenge/" + token;
    }
}
