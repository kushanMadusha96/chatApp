package lk.ijse.application.controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        final int PORT = 13085;
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("lk.ijse.application.controller.Server is running in port: " + PORT);

            Socket localSocket = serverSocket.accept();
            System.out.println("Client accepted..!");

            DataOutputStream dataOutputStream = new DataOutputStream(localSocket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(localSocket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String message = "", reply = "";

            while (!message.equals("finish")) {
                message = dataInputStream.readUTF();
                System.out.println("Client says , :" + message);
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
            }

            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
