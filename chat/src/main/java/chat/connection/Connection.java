package chat.connection;

import chat.DTO.MessageDTO;
import chat.GUI.Frame;

import java.io.*;
import java.net.*;

/**
 * The Connection class provides methods for handling communication between a client and a server in a chat application.
 * It includes functionality to send and receive messages, handle file transfers, and manage the network connection.
 */
public class Connection {
    private static Socket client;
    private static Socket server;

    /**
     * Converts the content of a file into a byte array.
     *
     * @param file The file to be converted.
     * @return A byte array representing the content of the file.
     */
    public static byte[] fileToByteArray(File file) {
        FileInputStream fis = null;

        try {
            try {
                fis = new FileInputStream(file);
                byte[] byteArray = new byte[(int) file.length()];
                int bytesRead = fis.read(byteArray);

                if (bytesRead < file.length()) {
                    throw new IOException("Can't read all file bytes: " + file.getName());
                }

                return byteArray;
            } finally {
                if (fis != null) {
                    fis.close();
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return new byte[0];
    }

    /**
     * Saves a file locally and updates the GUI with the saved file location.
     *
     * @param messageDTO The MessageDTO containing information about the file and its content.
     */
    public static void saveFileLocally(MessageDTO messageDTO) {
        if (server != null && messageDTO.getMessageFile() != null) {
            File file = messageDTO.getMessageFile();
            String fileName = file.getName();
            byte[] fileContent = messageDTO.getFileContent();

            String savePath = "src/main/resources/receivedFiles/" + fileName;

            try (FileOutputStream fos = new FileOutputStream(savePath)) {
                fos.write(fileContent);
                Frame.getInstance().addFileSavedLocation(savePath);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error at saving file");
            }
        } else {
            System.err.println("File is null or server unavailable");
        }
    }

    /**
     * Starts the server to listen for incoming connections and creates a thread to handle received messages.
     */
    public static void startServer() {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(12345);

            server = serverSocket.accept();

            Thread receiveMessageThread = new Thread(() -> receiveMessage(server));
            receiveMessageThread.start();
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

    /**
     * Starts the client and creates a thread to handle received messages.
     *
     * @param host The host address to connect to.
     */
    public static void startClient(String host) {
        try {
            client = new Socket(host, 12345);

            new Thread(() -> receiveMessage(client)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Listens for incoming messages on the given socket and processes them accordingly.
     *
     * @param socket The socket to receive messages from.
     */
    public static void receiveMessage(Socket socket) {
        while (true) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                try {
                    Object receivedObject = objectInputStream.readObject();

                    if (receivedObject instanceof MessageDTO) {
                        MessageDTO messageDTO = (MessageDTO) receivedObject;

                        if (messageDTO.getMessageFile() != null) {
                            saveFileLocally(messageDTO);
                            Frame.getInstance().addFileSentMessageToConversation(messageDTO);
                        } else {
                            Frame.getInstance().addMessageToConversation(messageDTO);
                        }
                    } else {
                        System.err.println("Received object is not an instance of MessageDTO");
                    }
                } catch (ClassCastException e) {
                    System.err.println("Error casting to MessageDTO: " + e.getMessage());
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Sends a MessageDTO to the connected client or server.
     *
     * @param messageDTO The MessageDTO to be sent.
     */
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

    /**
     * Disconnects the client and server sockets.
     */
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
