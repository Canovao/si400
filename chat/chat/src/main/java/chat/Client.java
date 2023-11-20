package chat;

import java.io.*;
import java.net.*;

public class Client {
    private static Socket socket;
    private static ObjectOutputStream out;
    private static final String SENDER = "Client";

    public static void start(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);

            System.out.println("Conexão estabelecida.");

            out = new ObjectOutputStream(socket.getOutputStream());

            sendMessage("Olá");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessage(String text) {
        try {
            MessageDTO message = new MessageDTO(SENDER, text);
            out.writeObject(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
