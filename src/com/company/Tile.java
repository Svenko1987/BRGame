package com.company;

public class Tile {
    private int xAxis;
    private int yAxis;
    private char value;


    public Tile() {
    }

    public Tile(int xAxis, int yAxis, char value) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.value= value;
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
