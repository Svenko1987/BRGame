package com.company;

public class Tile {
    private int xAxis;
    private int yAxis;
    private char value;
    private char emtyValue = '.';


    public void setTile(Tile tile) {
        this.xAxis = tile.getxAxis();
        this.yAxis = tile.getyAxis();
        this.value = tile.getValue();
    }

    public Tile(int xAxis, int yAxis, char value) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.value = value;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public char getValue() {
        return value;
    }

    public char getEmtyValue() {
        return emtyValue;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return
                "x" + xAxis +
                        ", y" + yAxis +
                        ", value=" + value;

    }
}
