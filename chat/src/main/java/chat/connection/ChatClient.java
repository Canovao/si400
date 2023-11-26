package chat.connection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

import chat.DTO.MessageDTO;
import chat.GUI.Frame;

public class ChatClient {
    private static Socket socket;
    private static ObjectOutputStream out;

    private ChatClient(){}

    public static void start(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);

            System.out.println("Connection established.");
            
            Frame.getInstance().updateConnectionStatus(getConnectionStatus());
            
            out = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessage(String message) {
        try {
            Frame.getInstance().addMessageToConversation(new MessageDTO(Frame.getUserInfo().getUsername(), message, new Date()));
            out.writeObject(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void sendFileMessage(MessageDTO message) {
    	try {
    		Frame.getInstance().addFileSentMessageToConversation(message);
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
