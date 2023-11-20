package chat;

import javax.swing.*;
import java.awt.*;

public class ChatGUI extends JFrame {
    private final JTextArea chatArea;
    private final JTextField messageField;
    private static ChatGUI instance;

    public ChatGUI() {
        instance = this;

        setTitle("Chat App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        messageField = new JTextField();
        JButton sendButton = new JButton("Enviar");
        sendButton.addActionListener(e -> sendMessage());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);
    }

    public static ChatGUI getInstance(){
        return instance;
    }

    private void sendMessage() {
        Client.sendMessage(messageField.getText());
        showMessageInScreen(new MessageDTO("Eu", messageField.getText()));
        messageField.setText("");
    }

    public void showMessageInScreen(MessageDTO message) {
        SwingUtilities.invokeLater(() -> chatArea.append(message.getSender() + ": " + message.getMessage() + "\n"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChatGUI chatGUI = new ChatGUI();
            chatGUI.setVisible(true);

            new Thread(() -> Server.start(9999)).start();

            new Thread(() -> Client.start("localhost", 9999)).start();
        });
    }
}
