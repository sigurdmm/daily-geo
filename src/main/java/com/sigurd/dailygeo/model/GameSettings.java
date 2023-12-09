package com.sigurd.dailygeo.model;

public record GameSettings(
        String map,
        boolean forbidMoving,
        boolean forbidRotating,
        boolean forbidZooming,
        int timeLimit,
        int rounds
) { }
