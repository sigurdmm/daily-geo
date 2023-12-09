package com.sigurd.dailygeo.controller;

import com.sigurd.dailygeo.model.GameSettings;
import com.sigurd.dailygeo.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sigurd.dailygeo.model.GeoguessrV3ApiModels.GameScores;

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

    @GetMapping("/url")
    public ResponseEntity<String> getGameUrl(
            @RequestParam(required = false, defaultValue = "62a44b22040f04bd36e8a914") String map,
            @RequestParam(required = false, defaultValue = "true") Boolean forbidMoving,
            @RequestParam(required = false, defaultValue = "false") Boolean forbidRotating,
            @RequestParam(required = false, defaultValue = "false") Boolean forbidZooming,
            @RequestParam(required = false, defaultValue = "60") Integer timeLimit,
            @RequestParam(required = false, defaultValue = "5") Integer rounds
    ) {
        GameSettings settings = new GameSettings(map, forbidMoving, forbidRotating, forbidZooming, timeLimit, rounds);
        String gameUrl = gameService.getGameUrl(settings);
        return ResponseEntity.ok(gameUrl);
    }
}
