package chat.connection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

import chat.DTO.ChatDTO;
import chat.GUI.ChatFrame;

public class ChatClient {
    private static Socket socket;
    private static ObjectOutputStream out;

    private ChatClient(){}

    public static void start(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);

            System.out.println("Connection established.");
            
            ChatFrame.getInstance().updateConnectionStatus(getConnectionStatus());
            
            out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessage(String message) {
        try {
            ChatFrame.getInstance().addMessageToConversation(new ChatDTO(ChatFrame.getUserInfo().getUsername(), message, new Date()));
            out.writeObject(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void sendFileMessage(ChatDTO message) {
    	try {
    		ChatFrame.getInstance().addFileSentMessageToConversation(message);
            out.writeObject(message);
            out.flush();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    public static boolean getConnectionStatus() {
    	return (socket != null);
    }
    
    public static Socket getSocket() {
    	return socket;
    }
}
