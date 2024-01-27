package src;

import java.net.Socket;
import java.io.*;

public class Client {
    Socket client;

    public Client() throws IOException {
        client = new Socket("89.223.126.189", 4444);
    }

    public void sendMessage(String message) throws IOException {
        OutputStream outputStream = client.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream, true);
        out.println(message);
        out.flush();
    }

    public String getMessage() throws IOException {
        InputStream inputStream = client.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        return in.readLine();
    }
}
