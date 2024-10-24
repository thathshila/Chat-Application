
package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class clientController {

    @FXML
    private AnchorPane anpClientForm;

    @FXML
    private Button btnClient;

    @FXML
    private TextField txtClient;

    @FXML
    private TextArea txtareaClient;

    String message = "";
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;

    public void initialize() {
        new Thread(() -> {
        try {
            Socket socket = new Socket("localhost", 4000);
            txtareaClient.appendText("Client Connected\n");
            txtareaClient.appendText("\nclient started\n");
             dataOutputStream = new DataOutputStream(socket.getOutputStream());
             dataInputStream = new DataInputStream(socket.getInputStream());

            while (!message.equals("exit")) {
                message = dataInputStream.readUTF();
                txtareaClient.appendText(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }).start();
    }
    public void btnClientOnAction(ActionEvent actionEvent) throws IOException {
    dataOutputStream.writeUTF(txtClient.getText().trim());
    dataOutputStream.flush();
    }
}
