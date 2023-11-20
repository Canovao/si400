package chat;

import java.io.*;
import java.net.*;

public class Server {
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;

    public static void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Aguardando conexão...");

            new Thread(() -> {
                try {
                    clientSocket = serverSocket.accept();
                    System.out.println("Conexão estabelecida.");

                    out = new ObjectOutputStream(clientSocket.getOutputStream());
                    in = new ObjectInputStream(clientSocket.getInputStream());

                    while (true) {
                        MessageDTO receivedMessage = (MessageDTO) in.readObject();
                        ChatGUI.getInstance().showMessageInScreen(receivedMessage);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
