package lk.ijse.application.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.application.controller.MainFormController;
import lk.ijse.application.controller.ServerClass;

import java.io.IOException;

public class serverInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/camera.fxml"))));
        primaryStage.show();
    }
}
