package com.company;


import java.util.*;

public class World {
    private int height;
    private int width;
    private final Set<Tile> grid = new LinkedHashSet<>();
    private final HashSet<Actor> actors = new HashSet<>();
    private Random r = new Random();


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
                Tile temp = new Tile(i, j, '.');
                this.grid.add(temp);
            }
        }
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

    public void playRound(int number) {
        for (int i = 0; i < number; i++) {
            actors.forEach(actor -> actor.pickAction(this));
            //printGrid();
            System.out.println("round : " + i + "___________________________________________________________________________________________________________________________________");
        }
    }

    public void printGrid() {
        getGrid().forEach(t -> {
            System.out.print(t.getValue());
            if (t.getyAxis() == width - 1) System.out.print("\n");
        });
    }

    public void setActors(int number) {
        for (int i = 0; i < number; i++) {
            addActor(i);
        }

    }

    public void addActor(int id) {

        int x = r.nextInt(height);
        int y = r.nextInt(width);
        System.out.println("positions " + x + " " + y);


        grid.forEach(tile -> {
            if (tile.getxAxis() == x && tile.getyAxis() == y) {
                if (tile.getValue() == '.') {
                    tile.setValue('p');
                    actors.add(new Actor(id, tile));
                } else {
                    System.out.println("not set at " + x + " " + y);
                    addActor(id);
                }
            }


        });

    }
    //


}

