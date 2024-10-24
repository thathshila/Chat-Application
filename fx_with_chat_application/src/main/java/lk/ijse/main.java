package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class main extends Application{

        public static void main(String[] args) {
            launch(args);
        }

        @Override
        public void start(Stage stage) throws Exception {

            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/server.fxml"));
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(anchorPane));
            stage1.setTitle("client Form");
            stage1.show();

    AnchorPane anchorPane1 = FXMLLoader.load(getClass().getResource("/view/client.fxml"));
          Stage stage2 = new Stage();
            stage2.setScene(new Scene(anchorPane1));
            stage2.setTitle("client Form");
            stage2.show();
        }
    }

