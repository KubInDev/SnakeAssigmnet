package com.me.snakeassigmnet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        World world = new World(25);

        BorderPane root = new BorderPane();
        SnakeGame game = new SnakeGame(world);
        Pane ui = SnakeGame.createUserInterface(world);

        game.setStyle("-fx-background-color: #30B080;");
        ui.setPadding(new Insets(10));

        root.setLeft(game);
        root.setRight(ui);

        Scene scene = new Scene(root);

        InputHandler inputHandler = new InputHandler(world);

        scene.setOnKeyPressed(inputHandler.getKeyHandler());
        scene.setOnMouseClicked(inputHandler.getMouseHandler());

        primaryStage.setTitle("Snake");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}