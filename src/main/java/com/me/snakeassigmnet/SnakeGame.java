package com.me.snakeassigmnet;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SnakeGame extends Pane {

    public static final int SCALE = 16;
    private World world;
    private AnimationTimer gameLoop;
    private Label scoreText;
    private Label runningText;

    public SnakeGame(World world) {
        setPrefSize(world.getSize() * SCALE, world.getSize() * SCALE);

        // TODO: Implement graphics
    }

    public static Pane createUserInterface(World world) {
        VBox ui = new VBox();

        Label scoreText = new Label();
        Label runningText = new Label("Press 's' to start");

        // TODO: Implement user interface

        ui.getChildren().addAll(scoreText, runningText);

        return ui;

    }
}
