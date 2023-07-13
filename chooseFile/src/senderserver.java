import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class senderserver {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234); // Port number to listen on

        System.out.println("Waiting for client to connect...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        // Read the image file
        File imageFile = new File("C:\\Users\\kushan\\Desktop\\New folder\\71735037.jpg");
        FileInputStream fis = new FileInputStream(imageFile);

        // Convert image to byte array
        byte[] imageData = new byte[(int) imageFile.length()];
        fis.read(imageData);

        // Open output stream and send the image data
        OutputStream os = socket.getOutputStream();
        os.write(imageData);

        System.out.println("Image sent.");

        // Close streams and socket
        os.close();
        fis.close();
        socket.close();
        serverSocket.close();
    }
}
