package com.company;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

public class WorldGraphics {

    private final Canvas canvas;
    private final TextArea textArea;


    public WorldGraphics(Canvas canvas, TextArea textArea) {

        this.canvas = canvas;
        this.textArea = textArea;
    }

    public void showOnCanvas(World world) {
        canvas.getGraphicsContext2D().setFill(Color.BROWN);
        canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getWidth());
        showStorm(world);
        showActors(world);

    }

    public void combatText(String s) {
        textArea.setText(textArea.getText() + "\n" + s);
        //textArea.appendText(s);
    }

    private void showStorm(World world) {
        canvas.getGraphicsContext2D().setFill(Color.BLUE);
        world.getGrid().stream()
                .filter(tile -> tile.getInStrorm())
                .forEach(tile -> canvas.getGraphicsContext2D().fillRect(tile.getxAxis() * 5, tile.getyAxis() * 5, 5, 5));
    }

    private void showActors(World world) {
        canvas.getGraphicsContext2D().setFill(Color.YELLOW);
        world.getActors().forEach(actor ->
                canvas.getGraphicsContext2D().fillRect(actor.getCurentLocation().getxAxis() * 5, actor.getCurentLocation().getyAxis() * 5, 5, 5));
    }

}
