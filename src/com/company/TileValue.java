package com.company;

public enum TileValue {
    PLAYER('p'),
    EMPTY('.'),
    POWERUP('u');
    private final char value;

    TileValue(char v) {
        value = v;
    }

    public char getValue() {
        return value;
    }
}
