package chat.GUI;

import javax.swing.*;

import chat.connection.ChatClient;
import chat.connection.ChatServer;

import java.awt.*;

public class ConnectionDialog extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 992994705610187333L;
	private JTextField ipField;
	private JTextField portField;
    private JTextField usernameField;

    public ConnectionDialog(Frame parent) {
        super(parent, "Connection", true);
        initializeUI();
    }

    private void initializeUI() {
    	JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel ipLabel = new JLabel("IP address:");
        ipField = new JTextField();
        JLabel portLabel = new JLabel("Port:");
        portField = new JTextField();
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        panel.add(ipLabel);
        panel.add(ipField);
        panel.add(portLabel);
        panel.add(portField);
        panel.add(usernameLabel);
        panel.add(usernameField);

        JButton connectButton = new JButton("Connect");
        connectButton.addActionListener(e -> {
            String ipAddress = ipField.getText();
            int port = Integer.parseInt(portField.getText());

            new Thread(() -> ChatServer.start(port)).start();
            new Thread(() -> ChatClient.start(ipAddress, port)).start();

            ((ChatFrame) getParent()).insertUsername();
            ((ChatFrame) getParent()).updateConnectionStatus(true);
            JOptionPane.showMessageDialog(ConnectionDialog.this, "Connection successfully established!", "Connection", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });
        panel.add(connectButton);
        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }
}
