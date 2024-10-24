package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Client {
    public static void main(String[] args) {
        try {
            //remote socket
            Socket socket = new Socket("localhost",3000);
            //request to the server
            String message = "hi i am client";
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //send the data
            System.out.println("server connected");
            //data reading option
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
            String message1 = dataInputStream.readUTF();
            System.out.println(message1);
            //close
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
