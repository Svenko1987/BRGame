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
        int turn=0;

        //world.playRound(100);
        world.playTillEnd();


        System.out.println(world.getActors());
        System.out.println(world.getNumberOfAlive());
        System.out.println("done");

    }
}
