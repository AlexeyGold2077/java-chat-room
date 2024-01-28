package src;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    private final ServerSocket serverSocket;
    Logger logger;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        logger = new Logger();
    }

    public void startServer() {
        try {
            System.out.println("Server start -- " + logger.getDateTime());
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected!");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
        Server server = new Server(serverSocket);
        server.startServer();
    }
}
