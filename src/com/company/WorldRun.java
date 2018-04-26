package com.company;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class WorldRun implements Runnable {
    private final World world;
    private Canvas canvas;
    private GraphicsContext graphicsContext;

    public WorldRun(World world, Canvas canvas, GraphicsContext graphicsContext) {
        this.world = world;
        this.canvas = canvas;
        this.graphicsContext = graphicsContext;
    }

    @Override
    public void run() {
        synchronized (world) {
            world.playOne();
            world.showOnCanvas(canvas, graphicsContext);

        }
    }
}
