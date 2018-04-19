package com.company;


import java.util.*;

public class World {
    private int height = 0;
    private int width = 0;
    private final Set<Tile> grid = new LinkedHashSet<>();
    Random r = new Random();

    public World() {

    }

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

    public void addTile(Tile tile) {
        this.grid.add(tile);
    }

    public Set<Tile> getGrid() {
        return grid;
    }

    public void addActor( Set<Actor> actors) {

        int x = r.nextInt(height);
        int y = r.nextInt(width);
        System.out.println("positions " + x + " " + y);
        Tile temp=grid.stream().filter(tile -> tile.getxAxis()==x && tile.getyAxis()==y).findFirst().get();

        grid.forEach(tile -> {
            if (tile.getxAxis() == x && tile.getyAxis() == y) {
                if (tile.getValue() == ' ') {
                    tile.setValue((char) (r.nextInt(25) + 'a'));
                    actors.add(new Actor("Mico",tile));
                } else {
                    System.out.println("not set at " + x + " " + y);
                    addActor(actors);
                }
            }


        });

    }
    //

    public void addPlayer() {
        grid.stream().findAny().ifPresent(s -> {
            if (s.getValue() == '_') {
                s.setValue((char) (r.nextInt(26) + 'a'));
                System.out.println("set");

            } else {
                System.out.println("not set");
                addPlayer();
            }

        });
    }
}
