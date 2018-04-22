package com.company;


public class Main {

    public static void main(String[] args) {
        // write your code here
        World world = new World(40, 150);


        world.generateGrid();


        // set Actors to world


        world.setActors(100);

        //print

        world.printGrid();
        world.playRound(100);

        System.out.println(world.getActors());
        System.out.println("done");

    }
}
