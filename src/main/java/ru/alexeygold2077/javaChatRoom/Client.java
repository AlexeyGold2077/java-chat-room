package ru.alexeygold2077.javaChatRoom;

import java.io.IOException;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;

public class Client {

    private static Socket socket = new Socket();
    private static SocketAddress serverAddr;
    private static final Integer CONNECTION_TIMEOUT = 10000;

    public static void main(String[] args) {
        try {
            serverAddr = _getServerInfo();
            socket.connect(serverAddr, CONNECTION_TIMEOUT);
        } catch (IOException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }


    }



    private static SocketAddress _getServerInfo() throws UnknownHostException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter server ip: ");
        String serverIp = scanner.nextLine();
        System.out.print("Enter server port: ");
        int serverPort = Integer.parseInt(scanner.nextLine());

        return new InetSocketAddress(InetAddress.getByName(serverIp), serverPort);
    }
}
