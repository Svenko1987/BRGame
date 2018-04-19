package com.sven.brgame.world;

public class Tile {
  private final int xAxis;
  private final int yAxis;
  private char value;

  /*
   * Tile ne može da postoji bez da su mu određene neke promjenjive koje niko kasnije ne mijenja, kao koordinate, zato ti
   * ne treba default konstruktor.
   *
   *   public Tile() {
   *  }
   */
  public Tile(int xAxis, int yAxis, char value) {
    this.xAxis = xAxis;
    this.yAxis = yAxis;
    this.value = value;
  }

  public int getY() {
    return yAxis;
  }

  public int getX() {
    return xAxis;
  }

  public char getValue() {
    return value;
  }

  public void setValue(char value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "x" + xAxis + ", y" + yAxis + ", value=" + value;

  }
}
