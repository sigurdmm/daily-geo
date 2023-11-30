package com.sigurd.geoguessr.controller;

import com.sigurd.geoguessr.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sigurd.geoguessr.model.GeoguessrV3ApiModels.GameScores;

@RestController
@RequestMapping("/api/game/")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String test() {
        return "Greetings from Game Controller!";
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameScores> getScoresFromGameId(
            @PathVariable String gameId,
            @RequestParam(required = false, defaultValue = "100") int limit
    ) {
        return ResponseEntity.ok(gameService.getScoresFromGameId(gameId, limit));
    }
}
