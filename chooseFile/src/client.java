import java.io.*;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234); // Server IP address and port number

        // Open input stream to receive image data
        InputStream is = socket.getInputStream();

        // Create a byte array to hold the received data
        byte[] imageData = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        // Read the image data into the byte array
        int bytesRead;
        while ((bytesRead = is.read(imageData)) != -1) {
            baos.write(imageData, 0, bytesRead);
        }

        // Convert the byte array back to an image file
        byte[] receivedData = baos.toByteArray();
//        FileOutputStream fos = new FileOutputStream("C:\\Users\\kushan\\Desktop\\images\\71735037.jpg");
//        fos.write(receivedData);

        System.out.println("Image received."+receivedData);

        // Close streams and socket
       // fos.close();
        baos.close();
        is.close();
        socket.close();
    }
}
