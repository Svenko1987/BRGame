package com.company;

public class Tile {
    private int xAxis;
    private int yAxis;
    private TileValue value;



    Tile(int xAxis, int yAxis, TileValue value) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.value = value;
    }



    int getxAxis() {
        return xAxis;
    }

    int getyAxis() {
        return yAxis;
    }

    TileValue getValue() {
        return value;
    }


    void setValue(TileValue value) {
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

