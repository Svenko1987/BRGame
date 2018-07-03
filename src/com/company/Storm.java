package com.company;

import javax.xml.transform.sax.SAXSource;

public class Storm {

    private Tile stormCenter;
    private int stormRadius=20;

    public void setStormCenter(World world){
        world.getGrid().stream()
                .filter(tile ->
                        (tile.getxAxis()==50 && tile.getyAxis()==50)
                )
                .findFirst()
                .ifPresent(tile -> stormCenter=tile);
        System.out.println(stormCenter);
    }
    public void createStorm(World world) {
        setStormCenter(world);
        world.getGrid().stream()
                .filter(tile -> isInRadius(tile))
                .forEach(tile -> tile.setInStrorm(true));


    }

    public boolean isInRadius(Tile tile) {
        boolean temp = false;
        if ((tile.getxAxis()-stormCenter.getxAxis()==stormRadius) &&
                (tile.getyAxis()-stormCenter.getyAxis()==stormRadius)
                )
            temp=true;
            return temp;
    }
}
