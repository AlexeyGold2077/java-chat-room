package src;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    private final ServerSocket serverSocket;
    private final Logger logger;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
        logger = new Logger();
    }

    public void startServer() {
        try {
            logger.logAnnouncement("Server started -- ");
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                logger.logAnnouncement("A new client has connected -- ");
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

    public static void main(String[] args) {
        ServerSocket serverSocket;
        Server server;
        try {
            serverSocket = new ServerSocket(Integer.parseInt(args[0]));
            server = new Server(serverSocket);
            server.startServer();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: to run requires port number as parameter");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
