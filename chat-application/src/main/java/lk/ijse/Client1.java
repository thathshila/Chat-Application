//package lk.ijse;
//
//import java.io.*;
//import java.net.Socket;
//import java.util.Scanner;
//
//
//public class Client1 {
//    public static void main(String[] args) {
//        try {
//            Socket socket = new Socket("localhost",3000);
//            DataInputStream dataInputStream = new DataInputStream( socket.getInputStream());
//            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            String message = "" , reply = "";
//            while (!message.equals("exit")) {
//                message = dataInputStream.readUTF();
//                System.out.println(message);
//                reply = bufferedReader.readLine();
//                dataOutputStream.writeUTF(message);
//                dataOutputStream.flush();
//            }
//            dataOutputStream.close();
//            dataInputStream.close();
//            bufferedReader.close();
//            socket.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
package lk.ijse;

import java.io.*;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000); // Connect to server


            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String message = "", reply = "";


            while (!message.equals("exit")) {
                message = dataInputStream.readUTF();
                System.out.println("Server: " + message);


                System.out.print("Client: ");
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
            }


            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
