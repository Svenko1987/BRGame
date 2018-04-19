package com.company;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // write your code here
        World world = new World(20, 20);
        Set<Actor> actors = new HashSet<>();

        for (int i = 0; i < world.getHeight(); i++) {
            for (int j = 0; j < world.getWidth(); j++) {
                Tile temp = new Tile(i, j, ' ');
                world.addTile(temp);
            }
        }
        Random r = new Random();


        // set Actors to world


        for (int i = 0; i < 10; i++) {
            world.addActor(actors);
        }

        //print
        world.getGrid().forEach(t -> {
            System.out.print(t.getValue());
            if (t.getyAxis() == world.getWidth() - 1) System.out.print("\n");
        });
        for (int i = 0; i < 1000; i++) {
            actors.forEach(actor -> actor.actorMove(world));
            world.getGrid().forEach(t -> {
                System.out.print(t.getValue());
                if (t.getyAxis() == world.getWidth() - 1) System.out.print("\n");
            });
            System.out.println("___________________________________________________________________________________________________________________________________");
        }

        System.out.println(actors);
        System.out.println("done");

    }
}
