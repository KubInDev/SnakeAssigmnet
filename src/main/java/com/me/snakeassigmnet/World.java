package com.me.snakeassigmnet;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.util.Duration;

import java.util.Random;

public class World {

    public final static int DELAY = 200;

    private final int size;

    private final Snake snake;
    private final Food food;

    private final Random random = new Random();

    private final BooleanProperty running = new SimpleBooleanProperty(false);

    private final IntegerProperty score = new SimpleIntegerProperty(0);
    private Timeline gameTimeline;

    public World(int size) {
        this.size = size;

        snake = new Snake(size / 2, size / 2, this);
        food = new Food();

        // TODO: Implement timeline
        initializeTimeline();

        moveFoodRandomly();
    }

    private void initializeTimeline() {
        gameTimeline = new Timeline(
                new KeyFrame(Duration.millis(DELAY), e -> gameUpdate())
        );
        gameTimeline.setCycleCount(Timeline.INDEFINITE);
    }

    private void gameUpdate() {
        if (isRunning()) {
            snake.move();
            checkCollisions();
        }
    }

    private void checkCollisions() {
        if (snake.isAt(food.getX(), food.getY())) {
            snake.grow();
            setScore(getScore() + 10);
            moveFoodRandomly();
        }


        if (snake.collidesWithItself() || !isInBounds(snake.getHeadX(), snake.getHeadY())) {
            endGame();
        }
    }

    private boolean isInBounds(int x, int y){
        return x>=0 && x < size && y>=0 && y<size;
    }

    public void moveFoodRandomly() {
        do {
            food.moveTo(random.nextInt(size), random.nextInt(size));
        } while (snake.isAt(food.getX(), food.getY()));
    }

    public void endGame() {
        running.set(false);
    }

    public void setRunning(boolean running) {
        this.running.set(running);
    }

    public void setScore(int score) {
        this.score.set(score);
    }

    public boolean isRunning() {
        return running.get();
    }

    public int getSize() {
        return size;
    }

    public int getScore() {
        return score.get();
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public BooleanProperty getRunningProperty() {
        return running;
    }

    public IntegerProperty getScoreProperty() {
        return score;
    }

}
