package chat.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import chat.DTO.MessageDTO;
import chat.GUI.Frame;

public class ChatServer {
    public static final int PORT = 12345;
	
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;

    private ChatServer(){
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Connecting...");

            new Thread(() -> {
                try {
                    clientSocket = serverSocket.accept();
                    System.out.println("Connection established!");

                    out = new ObjectOutputStream(clientSocket.getOutputStream());
                    in = new ObjectInputStream(clientSocket.getInputStream());

                    while (true) {
                        MessageDTO receivedMessage = (MessageDTO) in.readObject();
                        Frame.getInstance().addMessageToConversation(receivedMessage);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });

            Frame.getInstance().updateConnectionStatus(getConnectionStatus());
        } catch (IOException e) {
            System.err.println("Failed to connect to server: " + e.getMessage());
        }
    }

    public static void disconnect() {
        try {
            if (serverSocket != null && !serverSocket.isClosed() && clientSocket != null && !clientSocket.isClosed()) {
            	clientSocket.close();
                serverSocket.close();
                Frame.getInstance().updateConnectionStatus(getConnectionStatus());
                System.out.println("Connection ended.");
            }
        } catch (IOException e) {
            System.err.println("Error at ending connection: " + e.getMessage());
        }
    }
    
    public static boolean getConnectionStatus() {
    	return (serverSocket != null && clientSocket != null);
    }
    
    public static Socket getServerSocket() {
    	return clientSocket;
    }
}
