package com.company;

import javafx.application.Platform;
import javafx.scene.canvas.*;

import javafx.scene.paint.Color;

import java.util.TimerTask;
import java.util.Timer;

import java.util.*;

public class World {
    private int height;
    private int width;
    private final Set<Tile> grid = new LinkedHashSet<>();
    private final HashSet<Actor> actors = new HashSet<>();
    private Random r = new Random();
    public int numberOfAlive;
    private int turn = 0;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private WorldRun worldRun = new WorldRun(this, canvas, graphicsContext);


    public World(int height, int width) {
        this.height = height;
        this.width = width;

    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public void setCanvas(Canvas canvas) {

        this.canvas = canvas;
    }

    public int getHeight() {
        return height;
    }


    public int getWidth() {
        return width;
    }

    public void generateGrid() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile temp = new Tile(i, j, TileValue.EMPTY);
                this.grid.add(temp);
            }
        }
    }

    public int getTurn() {
        return turn;
    }

    public void incrementTurn() {
        this.turn++;
    }

    private void addTile(Tile tile) {
        this.grid.add(tile);
    }

    public Set<Tile> getGrid() {
        return grid;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public int getNumberOfAlive() {
        return numberOfAlive;
    }

    public void killPlayer() {
        this.numberOfAlive--;
    }

    public void playOne() {
        actors.forEach(actor -> {
            if (actor.isAlive()) actor.pickAction(this, worldGraphics);


        });
    }

    void startThread(Timer timer) {
        Runnable worldThread = new Thread(worldRun);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    synchronized (this) {
                        worldThread.run();
                    }
                });
            }

        };
        timer.schedule(timerTask, 200L, 75L);
    }

    public void playRound(int number) {
        for (int i = 0; i < number; i++) {
            actors.forEach(actor -> {
                if (actor.isAlive()) actor.pickAction(this,worldGraphics);

            });

            printGrid();
            System.out.println("round : " + i + "___________________________________________________________________________________________________________________________________");
        }
    }

    public void playTillEnd() {

        while (numberOfAlive > 1) {
            actors.forEach(actor -> {
                if (actor.isAlive()) actor.pickAction(this, worldGraphics);
                incrementTurn();

            });
        }

        System.out.println("Turn is: " + getTurn());
        printGrid();


    }

    public void printGrid() {
        getGrid().forEach(t -> {
            System.out.print(t.getValue().getValue());
            if (t.getyAxis() == width - 1) System.out.print("\n");
        });
    }

    public void showOnCanvas(Canvas canvas, GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.BROWN);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getWidth());
        graphicsContext.setFill(Color.YELLOW);
        actors.forEach(actor ->
                graphicsContext.fillRect(actor.getCurentLocation().getxAxis() * 5, actor.getCurentLocation().getyAxis() * 5, 5, 5)
        );


    }

    public void setActors(int number) {
        for (int i = 0; i < number; i++) {
            addActor(i);
        }
        this.numberOfAlive = number;

    }

    public void addActor(int id) {

        int x = r.nextInt(height);
        int y = r.nextInt(width);
        System.out.println("positions " + x + " " + y);


        grid.forEach(tile -> {
            if (tile.getxAxis() == x && tile.getyAxis() == y) {
                if (tile.getValue().equals(TileValue.EMPTY)) {
                    tile.setValue(TileValue.PLAYER);
                    actors.add(new Actor(id, tile, 1));
                } else {
                    System.out.println("not set at " + x + " " + y);
                    addActor(id);
                }
            }


        });

    }
    //


}

