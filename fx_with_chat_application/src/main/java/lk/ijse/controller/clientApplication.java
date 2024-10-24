package lk.ijse.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class clientApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader  = new FXMLLoader(clientApplication.class.getResource("/view/client.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Client Form");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {launch();}
}

