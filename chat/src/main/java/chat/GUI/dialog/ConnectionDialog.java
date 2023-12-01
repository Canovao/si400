package chat.GUI.dialog;

import javax.swing.*;

import chat.DTO.MessageDTO;
import chat.GUI.Frame;
import chat.connection.Connection;

import java.awt.*;
import java.util.Date;

/**
 * The ConnectionDialog class represents a dialog box for establishing a connection to the chat server.
 * It allows the user to input the server's IP address and their username, and provides a "Connect" button to initiate the connection.
 */
public class ConnectionDialog extends JDialog {
    private static final long serialVersionUID = 992994705610187333L;
    private JTextField ipField;
    private JTextField usernameField;

    /**
     * Constructs a ConnectionDialog.
     *
     * @param parent The parent JFrame to which the dialog is attached.
     */
    public ConnectionDialog(java.awt.Frame parent) {
        super(parent, "Connection", true);
        initializeUI();
    }

    /**
     * Initializes the UI components of the ConnectionDialog.
     * Sets up text fields for IP address and username, and a "Connect" button to initiate the connection.
     */
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

            MessageDTO userInfo = new MessageDTO(username, "", new Date());
            Frame.setUserInfo(userInfo);

            new Thread(() -> Connection.startClient(ipAddress)).start();

            ((Frame) getParent()).updateConnectionStatus(true);
            dispose();
        });
        panel.add(connectButton);
        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }
}
