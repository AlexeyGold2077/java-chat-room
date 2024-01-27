package src;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket server;

    public Server() throws IOException {
        server = new ServerSocket(4444);
    }

    public void run() throws IOException {
        while (true) {
             Socket socket = server.accept();

             InputStream inputStream = socket.getInputStream();
             BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
             String message = in.readLine();

             String reverseMessage = new StringBuilder(message).reverse().toString();

             OutputStream outputStream = socket.getOutputStream();
             PrintWriter out = new PrintWriter(outputStream, true);
             System.out.println(reverseMessage);
             out.println(reverseMessage);
             out.flush();
        }
    }
}
