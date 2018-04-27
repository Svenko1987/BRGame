package com.company;


import java.util.Random;


public class Actor {
    private String name;
    private int id;
    private int health;
    private Tile curentLocation;
    private Actor enemy;
    private boolean alive = true;

    private Random r = new Random();


    public Actor() {
    }

    private void setEnemy(Actor enemy) {
        this.enemy = enemy;
    }

    Actor(int id, Tile curentLocation, int health) {
        this.id = id;
        this.curentLocation = curentLocation;
        this.health = health;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }


    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
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
                //System.out.println(id + " dint move");
                break;
            case 1:
                move(world, Direction.UP);
                //System.out.println(id + " moved UP");
                break;
            case 2:
                move(world, Direction.DOWN);
                //System.out.println(id + " moved DOWN");
                break;
            case 3:
                move(world, Direction.LEFT);
                //System.out.println(id + " moved LEFT");
                break;
            case 4:
                move(world, Direction.RIGHT);
                //System.out.println(id + " moved RIGHT");
                break;
            default:
                System.out.println("peto");
                break;

        }


    }

    private void move(World world, Direction direction) {

        if (curentLocation.getxAxis() + direction.getDeltaX() >= 1 && curentLocation.getxAxis() + direction.getDeltaX() < world.getHeight() - 10
                && curentLocation.getyAxis() + direction.getDeltaY() >= 1 && curentLocation.getyAxis() + direction.getDeltaY() < world.getWidth() + 10) {
            world.getGrid().stream()
                    .filter(tile -> tile.getxAxis() == curentLocation.getxAxis() + direction.getDeltaX()
                            && tile.getyAxis() == curentLocation.getyAxis() + direction.getDeltaY())
                    .findFirst()
                    .ifPresent(validTile -> {
                        validTile.setValue(curentLocation.getValue());
                        {
                            world.getGrid().stream().
                                    filter(tile -> tile.equals(curentLocation)).
                                    findFirst().
                                    ifPresent(thisTile -> thisTile.setValue(TileValue.EMPTY));
                        }
                        curentLocation = validTile;
                    });

        } else actorMove(world);
    }

    void pickAction(World world, WorldGraphics worldGraphics) {
        if (enemyLocatio(world) != null) battle(world, worldGraphics);
        else actorMove(world);
    }

    private Actor enemyLocatio(World world) {
        scoutForPlayer(world, Direction.DOWN);
        scoutForPlayer(world, Direction.LEFT);
        scoutForPlayer(world, Direction.RIGHT);
        scoutForPlayer(world, Direction.UP);
        return enemy;
    }

    private void battle(World world, WorldGraphics worldGraphics) {

        world.getActors().stream()
                .filter(actor -> actor.getCurentLocation().equals(enemy.getCurentLocation()) && enemy.isAlive())
                .findFirst()
                .ifPresent(validActor -> {
                            worldGraphics.combatText("COMBAT " + this + " WITH " + validActor);
                            System.out.println("COMBAT " + this + " WITH " + validActor);
                            validActor.setHealth((validActor.getHealth() - 1));
                            world.getGrid().stream()
                                    .filter(tile -> tile.equals(validActor.getCurentLocation()))
                                    .findFirst()
                                    .ifPresent(validTile -> {
                                        validTile.setValue(TileValue.EMPTY);
                                        validActor.setAlive(false);
                                        validActor.setCurentLocation(new Tile(-1, -1, TileValue.PLAYER));
                                        world.killPlayer();
                                        this.enemy = null;
                                        worldGraphics.combatText("player killed " + validActor);
                                        System.out.println("player killed " + validActor);
                                    });


                        }
                );
    }

    private void scoutForPlayer(World world, Direction direction) {

        world.getGrid().stream()
                .filter(tile -> tile.getxAxis() == curentLocation.getxAxis() + direction.getDeltaX()
                        && tile.getyAxis() == curentLocation.getyAxis() + direction.getDeltaY()
                        && tile.getValue().equals(TileValue.PLAYER))
                .findFirst()
                .ifPresent(validTile -> world.getActors().stream()
                        .filter(actor -> actor.getCurentLocation().equals(validTile)
                                && actor.isAlive())
                        .findFirst()
                        .ifPresent(validActor -> setEnemy(validActor)));
    }

    private void dontMove() {
    }

    @Override
    public String toString() {
        return "Actor{" +
                "ID='" + id + '\'' +
                "HP=" + health + '\'' +
                '}';
    }
}
