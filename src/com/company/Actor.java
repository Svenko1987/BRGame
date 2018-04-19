package com.company;


import java.util.Random;

public class Actor {
    private String name;
    private Tile curentLocation;
    Random r = new Random();

    public Actor() {
    }

    public Actor(String name, Tile curentLocation) {
        this.name = name;
        this.curentLocation = curentLocation;
    }

    public void setCurentLocation(Tile curentLocation) {
        this.curentLocation = curentLocation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Tile getCurentLocation() {
        return curentLocation;
    }

    //movement
    public void actorMove(World world) {
        int val = r.nextInt(5);
        switch (val) {
            case 0:
                dontMove();
                break;
            case 1:
                moveDown(world);
                break;
            case 2:
                moveUp(world);
                break;
            case 3:
                moveLeft(world);
                break;
            case 4:
                moveRight(world);
                break;
            default:
                System.out.println("peto");
                break;

        }


    }

    private void dontMove() {

        //System.out.println(curentLocation.getxAxis()+" "+curentLocation.getyAxis()+" did'nt move");

    }

    private void moveUp(World world) {
        if (curentLocation.getxAxis() != 0) {
            world.getGrid().stream().filter(tile ->
                tile.getxAxis() == curentLocation.getxAxis() - 1 && tile.getyAxis() == curentLocation.getyAxis()
            ).findFirst().get().setValue(world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().getValue());
            world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().setValue(' ');
            this.curentLocation=world.getGrid().stream().filter(tile ->
                    tile.getxAxis() == curentLocation.getxAxis() - 1 && tile.getyAxis() == curentLocation.getyAxis()
            ).findFirst().get();

            //System.out.println(curentLocation.getxAxis() + " " + curentLocation.getyAxis() + " move up");
        }
        else actorMove(world);

    }

    private void moveDown(World world) {
        if (curentLocation.getxAxis() != world.getHeight()-1) {
            world.getGrid().stream().filter(tile ->
                    tile.getxAxis() == curentLocation.getxAxis() + 1 && tile.getyAxis() == curentLocation.getyAxis()
            ).findFirst().get().setValue(world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().getValue());
            world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().setValue(' ');
            this.curentLocation=world.getGrid().stream().filter(tile ->
                    tile.getxAxis() == curentLocation.getxAxis() + 1 && tile.getyAxis() == curentLocation.getyAxis()
            ).findFirst().get();

            //System.out.println(curentLocation.getxAxis()+" "+curentLocation.getyAxis()+" move down");


        }
        else actorMove(world);
    }

    private void moveLeft(World world) {
        if (curentLocation.getyAxis() != 0){
            world.getGrid().stream().filter(tile ->
                    tile.getxAxis() == curentLocation.getxAxis() && tile.getyAxis() == curentLocation.getyAxis()-1
            ).findFirst().get().setValue(world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().getValue());
            world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().setValue(' ');
            this.curentLocation=world.getGrid().stream().filter(tile ->
                    tile.getxAxis() == curentLocation.getxAxis() && tile.getyAxis() == curentLocation.getyAxis()-1
            ).findFirst().get();
            //System.out.println(curentLocation.getxAxis()+" "+curentLocation.getyAxis()+" move left");
        }
        else actorMove(world);
    }

    private void moveRight(World world) {
        if (curentLocation.getyAxis() != world.getWidth()-1){
            world.getGrid().stream().filter(tile ->
                    tile.getxAxis() == curentLocation.getxAxis() && tile.getyAxis() == curentLocation.getyAxis()+1
            ).findFirst().get().setValue(world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().getValue());
            world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().setValue(' ');
            this.curentLocation=world.getGrid().stream().filter(tile ->
                    tile.getxAxis() == curentLocation.getxAxis() && tile.getyAxis() == curentLocation.getyAxis()+1
            ).findFirst().get();
            //System.out.println(curentLocation.getxAxis()+" "+curentLocation.getyAxis()+" move right");
        }
        else actorMove(world);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", curentLocation=" + curentLocation +
                '}';
    }
}
