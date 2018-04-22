package com.company;

public enum Direction {
    UP (-1, 0),
    DOWN(1, 0),
    LEFT(0, -1),
    RIGHT(0, 1);

    private final int deltaX;
    private final int deltaY;

    Direction(int x, int y ){
        deltaX=x;
        deltaY=y;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }
}
