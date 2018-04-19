package com.sven.brgame.actor;

/**
 * Author: Mirza <mirza.suljic.ba@gmail.com>
 * Date: 19.4.2018. @ 20:51
 */
public enum Direction {
  UP(-1,0),
  DOWN(1,0),
  LEFT(-1,0),
  RIGHT(1,0);

  private final int deltaX;
  private final int deltaY;

  Direction(int deltaX, int deltaY) {
    this.deltaX = deltaX;
    this.deltaY = deltaY;
  }

  public int getDeltaX() {
    return deltaX;
  }

  public int getDeltaY() {
    return deltaY;
  }
}
