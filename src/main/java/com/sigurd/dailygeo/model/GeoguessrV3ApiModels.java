package com.sigurd.dailygeo.model;

import java.util.List;

public class GeoguessrV3ApiModels {

    public record GameScores(List<GameItem> items, String paginationToken) {}

    public record GameItem(String gameToken, String playerName, String userId, int totalScore, boolean isLeader, String pinUrl, Game game) {}

    public record Game(String token, String type, String mode, String state, int roundCount, int timeLimit, boolean forbidMoving, boolean forbidZooming, boolean forbidRotating, String streakType, String map, String mapName, int panoramaProvider, Bounds bounds, int round, List<Round> rounds, Player player, ProgressChange progressChange) {}

    public record Round(double lat, double lng, String panoId, double heading, double pitch, int zoom, String streakLocationCode, String startTime) {}

    public record Bounds(Coordinate min, Coordinate max) {}

    public record Coordinate(double lat, double lng) {}

    public record Player(TotalScore totalScore, TotalDistance totalDistance, double totalDistanceInMeters, int totalTime, int totalStreak, List<Guess> guesses, boolean isLeader, int currentPosition, Pin pin, List<Object> newBadges, Object explorer, String id, String nick, boolean isVerified, int flair, String countryCode) {}

    public record TotalScore(String amount, String unit, double percentage) {}

    public record TotalDistance(Distance meters, Distance miles) {}

    public record Distance(double amount, String unit) {}

    public record Guess(double lat, double lng, boolean timedOut, boolean timedOutWithGuess, boolean skippedRound, Score roundScore, double roundScoreInPercentage, int roundScoreInPoints, Distance distance, double distanceInMeters, String streakLocationCode, int time) {}

    public record Score(String amount, String unit, double percentage) {}

    public record Pin(String url, String anchor, boolean isDefault) {}

    public record ProgressChange(List<XpProgression> xpProgressions, AwardedXp awardedXp) {}

    public record XpProgression(int xp, Level currentLevel, Level nextLevel, Title currentTitle) {}

    public record Level(int level, int xpStart) {}

    public record Title(int id, int tierId, int minimumLevel, String name) {}

    public record AwardedXp(int totalAwardedXp, List<XpAward> xpAwards) {}

    public record XpAward(int xp, String reason, int count) {}

}
