module com.me.snakeassigmnet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.me.snakeassigmnet to javafx.fxml;
    exports com.me.snakeassigmnet;
}