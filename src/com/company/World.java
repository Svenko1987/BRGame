package com.company;


import java.util.*;

public class World {
    private int height;
    private int width;
    private final Set<Tile> grid = new LinkedHashSet<>();
    private final HashSet<Actor> actors = new HashSet<>();
    private Random r = new Random();
    public int numberOfAlive;
    private int turn = 0;


    public World(int height, int width) {
        this.height = height;
        this.width = width;
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

    public void playRound(int number) {
        for (int i = 0; i < number; i++) {
            actors.forEach(actor -> {
                if (actor.isAlive()) actor.pickAction(this);

            });

            printGrid();
            System.out.println("round : " + i + "___________________________________________________________________________________________________________________________________");
        }
    }

    public void playTillEnd() {

        while (numberOfAlive > 1) {
            actors.forEach(actor -> {
                if (actor.isAlive()) actor.pickAction(this);
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

