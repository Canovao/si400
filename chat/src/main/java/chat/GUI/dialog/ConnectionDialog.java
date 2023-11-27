package chat.GUI.dialog;

import javax.swing.*;

import chat.DTO.MessageDTO;
import chat.GUI.Frame;
import chat.connection.ChatClient;
import chat.connection.ChatServer;

import java.awt.*;
import java.util.Date;

public class ConnectionDialog extends JDialog {
	private static final long serialVersionUID = 992994705610187333L;
	private JTextField ipField;
    private JTextField usernameField;

    public ConnectionDialog(java.awt.Frame parent) {
        super(parent, "Connection", true);
        initializeUI();
    }

    private void initializeUI() {
    	JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel ipLabel = new JLabel("IP address:");
        ipField = new JTextField();
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        panel.add(ipLabel);
        panel.add(ipField);
        panel.add(usernameLabel);
        panel.add(usernameField);

        
        JButton connectButton = new JButton("Connect");
        connectButton.addActionListener(e -> {
            String ipAddress = ipField.getText();
            String username = usernameField.getText();

            if (username != null && !username.trim().isEmpty()) {
                MessageDTO userInfo = new MessageDTO(username, "joined!", new Date());
                Frame.setUserInfo(userInfo);
                Frame.getInstance().addMessageToConversation(userInfo);
            } else if (username != null) {
                JOptionPane.showMessageDialog(this.getParent(), "Invalid username!", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
            	ChatServer.disconnect();
                return;
            }

            new Thread(() -> ChatClient.start(ipAddress, ChatServer.PORT)).start();

            ((Frame) getParent()).updateConnectionStatus(true);
            dispose();
        });
        panel.add(connectButton);
        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }
}
