package com.sven.brgame.actor;

import com.sven.brgame.world.Tile;
import com.sven.brgame.world.World;

import java.util.Random;

public class AbstractActor {
  private String name;
  private Tile curentLocation;
  private Random random = new Random();

  public AbstractActor() {
  }

  public AbstractActor(String name, Tile currentLocation) {
    this.name = name;
    this.curentLocation = currentLocation;
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
    int val = random.nextInt(5);
    switch (val) {
      case 0:
        dontMove();
        break;
      case 1:
        moveDown(world);
        break;
      case 2:
        move(world, Direction.UP);
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

  private void move(World world, Direction direction) {
    if (curentLocation.getY() != 0) {
      world.getGrid().stream()
          .filter(tile -> tile.getX() == curentLocation.getX() + direction.getDeltaX() && tile.getY() == curentLocation.getY() + direction.getDeltaY())
          .findFirst()
          .ifPresent(validTile -> validTile.setValue(world.getGrid().stream()
              .filter(tile -> tile.equals(curentLocation))
              .findFirst()
              .get().getValue()));

      world.getGrid().stream()
          .filter(tile -> tile.equals(curentLocation))
          .findFirst()
          .get().setValue(' ');

      curentLocation = world.getGrid().stream()
          .filter(tile -> tile.getY() == curentLocation.getY() - 1 && tile.getX() == curentLocation.getX())
          .findFirst()
          .get();

      //System.out.println(curentLocation.getxAxis() + " " + curentLocation.getyAxis() + " move up");
    }
    else {
      actorMove(world);
    }
  }

  private void moveDown(World world) {
    if (curentLocation.getY() != world.getHeight() - 1) {
      world.getGrid().stream().filter(tile ->
          tile.getY() == curentLocation.getY() + 1 && tile.getX() == curentLocation.getX()
      ).findFirst().get().setValue(world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().getValue());
      world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().setValue(' ');
      this.curentLocation = world.getGrid().stream().filter(tile ->
          tile.getY() == curentLocation.getY() + 1 && tile.getX() == curentLocation.getX()
      ).findFirst().get();

      //System.out.println(curentLocation.getxAxis()+" "+curentLocation.getyAxis()+" move down");


    }
    else actorMove(world);
  }

  private void moveLeft(World world) {
    if (curentLocation.getX() != 0) {
      world.getGrid().stream().filter(tile ->
          tile.getY() == curentLocation.getY() && tile.getX() == curentLocation.getX() - 1
      ).findFirst().get().setValue(world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().getValue());
      world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().setValue(' ');
      this.curentLocation = world.getGrid().stream().filter(tile ->
          tile.getY() == curentLocation.getY() && tile.getX() == curentLocation.getX() - 1
      ).findFirst().get();
      //System.out.println(curentLocation.getxAxis()+" "+curentLocation.getyAxis()+" move left");
    }
    else actorMove(world);
  }

  private void moveRight(World world) {
    if (curentLocation.getX() != world.getWidth() - 1) {
      world.getGrid().stream().filter(tile ->
          tile.getY() == curentLocation.getY() && tile.getX() == curentLocation.getX() + 1
      ).findFirst().get().setValue(world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().getValue());
      world.getGrid().stream().filter(tile -> tile.equals(curentLocation)).findFirst().get().setValue(' ');
      this.curentLocation = world.getGrid().stream().filter(tile ->
          tile.getY() == curentLocation.getY() && tile.getX() == curentLocation.getX() + 1
      ).findFirst().get();
      //System.out.println(curentLocation.getxAxis()+" "+curentLocation.getyAxis()+" move right");
    }
    else actorMove(world);
  }

  @Override
  public String toString() {
    return "AbstractActor{" +
        "name='" + name + '\'' +
        ", curentLocation=" + curentLocation +
        '}';
  }
}
