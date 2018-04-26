package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;


import javafx.scene.canvas.*;

import java.util.Timer;


public class Interface extends Application {
    Stage window;
    Scene scene;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        World world = new World(120, 140);


        window = primaryStage;
        window.setTitle("BRGame");
        Canvas canvas = new Canvas(world.getWidth() * 5, world.getHeight() * 5);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.BROWN);
        graphicsContext.fillRect(0, 0, canvas.getWidth(), canvas.getWidth());
        world.setCanvas(canvas);
        world.setGraphicsContext(graphicsContext);


        Label topLable = new Label("this is top");
        Button generate = new Button("Genarate");
        generate.setOnAction(event -> {
            world.generateGrid();
            world.setActors(100);
            world.showOnCanvas(canvas, graphicsContext);


        });
        Button playGame = new Button("Run-BROKEN");
        playGame.setOnAction(event -> {
            world.startThread(new Timer());
        });
        Button test = new Button("Play one turn");
        test.setOnAction(event -> {
            world.playOne();
            world.showOnCanvas(canvas, graphicsContext);
        });

        VBox topV = new VBox();
        topV.getChildren().addAll(generate, test, playGame);
        BorderPane root = new BorderPane();

        root.setTop(topLable);
        root.setCenter(canvas);
        root.setBottom(new javafx.scene.control.Label("botton"));
        root.setLeft(new javafx.scene.control.Label("Left"));
        root.setRight(topV);

        scene = new Scene(root, 800, 800);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
