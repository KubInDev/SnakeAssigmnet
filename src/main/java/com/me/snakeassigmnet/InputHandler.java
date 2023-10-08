package com.me.snakeassigmnet;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class InputHandler {
    private final EventHandler<KeyEvent> keyHandler;
    private final EventHandler<MouseEvent> mouseHandler;

    public InputHandler(World world) {
        Snake snake = world.getSnake();

        keyHandler = keyEvent -> {
            // TODO: Implement controls
            keyEvent.consume();
        };

        mouseHandler = mouseEvent -> {
            // TODO: Implement mouse
            mouseEvent.consume();
        };
    }

    public EventHandler<KeyEvent> getKeyHandler() {
        return keyHandler;
    }

    public EventHandler<MouseEvent> getMouseHandler() {
        return mouseHandler;
    }
}
