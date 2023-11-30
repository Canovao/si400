package chat.connection;

import chat.DTO.MessageDTO;
import chat.GUI.Frame;

import java.io.*;
import java.net.*;

public class Chat {
    private static Socket client;
    private static Socket server;

    public static void startServer() {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(12345);

            server = serverSocket.accept();

            Thread threadReceber = new Thread(() -> receiveMessage(server));
            threadReceber.start();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void startClient(String host) {
        try {
            client = new Socket(host, 12345);

            Thread threadReceber = new Thread(() -> receiveMessage(client));
            threadReceber.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void receiveMessage(Socket socket) {
        while (true){
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                MessageDTO messageDTO = (MessageDTO) objectInputStream.readObject();
                Frame.getInstance().addMessageToConversation(messageDTO);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendMessage(MessageDTO messageDTO) {
        try {
            if (client != null) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
                objectOutputStream.writeObject(messageDTO);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() {
        try {
            if (server != null && !server.isClosed()) {
                server.close();
            }
            if (client != null && !client.isClosed()) {
                client.close();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}


