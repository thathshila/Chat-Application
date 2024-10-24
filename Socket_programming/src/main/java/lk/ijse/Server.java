package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args)  {
            //server socket
        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            //local socket
            Socket socket = serverSocket.accept();
            System.out.println("client connected");
            //data reading option
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String message = "hi i am server";
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            //send the data
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
            //sout
            String message1 = dataInputStream.readUTF();
            System.out.println(message1);
            //connection close
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
//Scanner clientInput = new Scanner(socket.getInputStream());
//String clientMessage = clientInput.nextLine();
//            System.out.println(clientMessage);