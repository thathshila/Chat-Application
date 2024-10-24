//package lk.ijse;
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class Server1 {
//    public static void main(String[] args)  {
//        //server socket
//        try {
//            ServerSocket serverSocket = new ServerSocket(3000);
//            //local socket
//            Socket socket = serverSocket.accept();
//            System.out.println("server accepted");
//            //data reading option
//            DataInputStream dataInputStream = new DataInputStream( socket.getInputStream());
//            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            //send the data
//            String message = "" , reply = "";
//            //sout
//            while (!message.equals("exit")) {
//                message = dataInputStream.readUTF();
//                System.out.println(message);
//                reply = bufferedReader.readLine();
//                dataOutputStream.writeUTF(message);
//                dataOutputStream.flush();
//            }
//            //connection close
//           dataInputStream.close();
//            dataOutputStream.close();
//            bufferedReader.close();
//            socket.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
package lk.ijse;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args)  {
        try {

            ServerSocket serverSocket = new ServerSocket(3000);
            Socket socket = serverSocket.accept(); // Wait for client connection
            System.out.println("Server accepted connection");


            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String message = "", reply = "";


            while (!message.equals("exit")) {
                System.out.print("Server: ");
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();


                message = dataInputStream.readUTF();
                System.out.println("Client: " + message);
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
