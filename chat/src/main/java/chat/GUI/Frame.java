package chat.GUI;

import javax.swing.*;

import chat.connection.Connection;
import chat.DTO.MessageDTO;
import chat.GUI.dialog.AboutDialog;
import chat.GUI.dialog.ConnectionDialog;
import chat.GUI.dialog.HelpDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.Serial;
import java.util.Date;

/**
 * The Frame class represents the main graphical user interface (GUI) for the chat application.
 * It includes components for displaying conversations, sending messages, and managing connections.
 */
public class Frame extends JFrame implements ActionListener{
	@Serial
    private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JTextArea conversationArea;
	private JTextField textField;
	private JButton sendButton;
	private JMenuBar menuBar;
	private JMenu fileMenu, helpMenu;
	private JMenuItem connectItem, exitItem, helpItem, aboutItem;
	private JLabel statusBar;
	private MessageDTO userInfo;
	private static Frame instance;
    /**
     * Sets the user information for the chat application.
     *
     * @param userInfo The user information to set.
     */
    public static void setUserInfo(MessageDTO userInfo){
        getInstance().userInfo = userInfo;
    }
    /**
     * Gets the user information for the chat application.
     *
     * @return The user information.
     */
    public static MessageDTO getUserInfo(){
        return getInstance().userInfo;
    }
    /**
     * Constructs a Frame instance, initializing the GUI components and setting up the menu bar.
     */
    public Frame() {
        super(Constants.NAME_VERSION);
        instance = this;
        configureFrame();
        createAndAddMenuBar();
        addListenersMenu(this);
        addComponents();
    }
    /**
     * Retrieves the singleton instance of the Frame class.
     *
     * @return The singleton instance of the Frame class.
     */
    public static Frame getInstance() {
    	return instance;
    }

    /**
     * Start method that set te GUI visible
     */
    public void start() {
    	this.setVisible(true);
    }

    /**
     * Configures the main frame's properties, such as title, size, and default close operation.
     */
    private void configureFrame() {
        this.setTitle(Constants.NAME);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.white);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * Creates and adds the menu bar with File and Help menus to the main frame.
     */
    private void createAndAddMenuBar() {
    	menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');
        connectItem = new JMenuItem("Add Connection");
        connectItem.setMnemonic('C');
        exitItem = new JMenuItem("Exit " + Constants.NAME);
        exitItem.setMnemonic('E');

        helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');
        helpItem = new JMenuItem("Starting a chat");
        helpItem.setMnemonic('S');
        aboutItem = new JMenuItem("About");
        aboutItem.setMnemonic('A');

        fileMenu.add(connectItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        helpMenu.add(helpItem);
        helpMenu.addSeparator();
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        menuBar.setBackground(Color.LIGHT_GRAY);
        this.setJMenuBar(menuBar);
    }

    /**
     * Adds action listeners to menu items in the menu bar.
     *
     * @param listener The action listener to be added to the menu items.
     */
    private void addListenersMenu(ActionListener listener) {
    	for(Component menu : this.getJMenuBar().getComponents()) {
    		if(menu instanceof JMenu) {
    			addListenersItemMenu(listener, (JMenu) menu);
    		}
    	}
    }

    /**
     * Adds action listeners to individual items in a menu.
     *
     * @param listener The action listener to be added to the menu items.
     * @param menu     The menu containing the items to which the listener will be added.
     */
    private void addListenersItemMenu(ActionListener listener, JMenu menu) {
    	for (Component item : menu.getMenuComponents()) {
    		if(item instanceof JMenuItem) {
    			((JMenuItem) item).addActionListener(listener);
    		}
    	}
    }

    /**
     * Handles action events triggered by menu items.
     *
     * @param event The action event to be handled.
     */
    public void actionPerformed(ActionEvent event) {
    	if(event.getSource() == connectItem) {
    		ConnectionDialog dialog = new ConnectionDialog(Frame.this);
            dialog.setSize(300, 150);
            dialog.setLocationRelativeTo(Frame.this);
            dialog.setVisible(true);
    	}
    	if(event.getSource() == aboutItem) {
    		(new AboutDialog(Frame.this)).setVisible(true);
    	}
    	if(event.getSource() == helpItem) {
    		(new HelpDialog(Frame.this)).setVisible(true);
    	}
        if(event.getSource() == exitItem) {
            Connection.disconnect();
            System.exit(0);
        }
    }

    /**
     * Adds various components to the main frame, including a status bar, content panel, conversation area,
     * and message input area.
     */
    private void addComponents() {
    	addStatusBar();
    	addContentPanel();
    	addConversationArea();
    	addMessageInput();
    }

    /**
     * Adds a status bar to the main frame indicating the connection status.
     */
    private void addStatusBar() {
    	JPanel statusPanel = new JPanel();
    	statusPanel.setBackground(Color.white);
    	statusBar = new JLabel("Connection Status: Not Connected");
    	statusPanel.add(statusBar);
    	this.add(statusPanel, BorderLayout.SOUTH);
    }

    /**
     * Updates the connection status in the status bar.
     *
     * @param connected True if connected, false otherwise.
     */
    public void updateConnectionStatus(boolean connected) {
        statusBar.setText("Connection: " + ((connected) ? "Connected": "Disconnected"));
    }

    /**
     * Adds a content panel to the main frame with left and right space.
     */
    private void addContentPanel() {
    	contentPanel = new JPanel(new BorderLayout());

    	JPanel leftSpace = new JPanel();
    	JPanel rightSpace = new JPanel();
    	leftSpace.setPreferredSize(new Dimension(50, 0));
    	rightSpace.setPreferredSize(new Dimension(50, 0));

    	contentPanel.add(leftSpace, BorderLayout.WEST);
    	contentPanel.add(rightSpace, BorderLayout.EAST);
    	this.add(contentPanel, BorderLayout.CENTER);
    }

    /**
     * Adds a conversation area to the main frame, including a scrollable text area for displaying messages.
     */
    private void addConversationArea() {
    	JPanel chatPanel = new JPanel(new BorderLayout());

    	JPanel spaceTop = new JPanel();
    	spaceTop.setPreferredSize(new Dimension(Integer.MAX_VALUE, 30));
    	chatPanel.add(spaceTop, BorderLayout.NORTH);

    	conversationArea = new JTextArea();
    	conversationArea.setEditable(false);
    	JScrollPane scrollPane = new JScrollPane(conversationArea);
    	chatPanel.add(scrollPane, BorderLayout.CENTER);

    	contentPanel.add(chatPanel, BorderLayout.CENTER);
    }

    /**
     * Formats a message to ensure proper display in the conversation area.
     *
     * @param message The message to be formatted.
     * @return The formatted message.
     */
    public String formatMessage(String message) {
        final int MAX_CHARACTERS_PER_LINE = 90;
        StringBuilder formattedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i += MAX_CHARACTERS_PER_LINE) {
            int endIndex = Math.min(i + MAX_CHARACTERS_PER_LINE, message.length());
            formattedMessage.append(message.substring(i, endIndex));

            if (endIndex < message.length()) {
                formattedMessage.append("\n");
            }
        }

        return formattedMessage.toString();
    }

    /**
     * Appends a message to the conversation area indicating that a file has been saved at the specified path.
     *
     * @param path The path where the file has been saved.
     */
    public void addFileSavedLocation(String path) {
        SwingUtilities.invokeLater(() -> conversationArea.append("File saved at: " + path + "\n\n"));
    }

    /**
     * Sends a text message to the connected user and updates the conversation area with the message sent.
     * Clears the text field after sending the message.
     */
    public void sendMessage() {
        String message = textField.getText();
        Connection.sendMessage(new MessageDTO(getUserInfo().getUsername(), message, new Date()));
        addMessageToConversation(new MessageDTO("Me", message, new Date()));
        textField.setText("");
    }

    /**
     * Sends a file message to the connected user and updates the conversation area with the file message sent.
     * Clears the text field after sending the file message.
     *
     * @param file The file to be sent.
     */
    public void sendFileMessage(File file) {
        Connection.sendMessage(new MessageDTO(getUserInfo().getUsername(), new Date(), file, Connection.fileToByteArray(file)));
        addFileSentMessageToConversation(new MessageDTO("Sent file: ", file.getName(), new Date()));
        textField.setText("");
    }

    /**
     * Adds a message to the conversation area, distinguishing between regular messages and file-related messages.
     *
     * @param receivedMessage The received message to be added to the conversation area.
     */
    public void addMessageToConversation(MessageDTO receivedMessage) {
        if (receivedMessage.getMessageFile() != null) {
            conversationArea.append(receivedMessage.getUsername() + ":\n" + "Received file: " + receivedMessage.getMessageFile().getName() + "\n\n");
        } else {
            String message = receivedMessage.getMessage();
            SwingUtilities.invokeLater(() -> conversationArea.append(receivedMessage.getUsername() + " - " + receivedMessage.getDateTimeOfMessage() + ":\n" + formatMessage(message) + "\n\n"));
        }
    }

    /**
     * Adds a file-related message to the conversation area.
     *
     * @param receivedFileMessage The received file-related message to be added to the conversation area.
     */
    public void addFileSentMessageToConversation(MessageDTO receivedFileMessage) {
        addMessageToConversation(receivedFileMessage);
        textField.setText("");
    }

    /**
     * Retrieves an ImageIcon scaled to a specified size.
     *
     * @param path The path to the image file.
     * @param size The size to which the image should be scaled.
     * @return The scaled ImageIcon.
     */
    public static ImageIcon getImage(String path, int size){
        ImageIcon originalIcon = new ImageIcon(path);
        Image originalImage = originalIcon.getImage();
        return new ImageIcon(originalImage.getScaledInstance(size, size, Image.SCALE_SMOOTH));
    }

    /**
     * Adds the message input area to the main frame, including text input, send button, and file selection button.
     */
    private void addMessageInput() {
    	JPanel panel = new JPanel(new BorderLayout());
    	
    	JPanel spaceTop = new JPanel();
    	spaceTop.setPreferredSize(new Dimension(Integer.MAX_VALUE, 20));
    	
    	JPanel spaceBottom = new JPanel();
    	spaceBottom.setPreferredSize(new Dimension(Integer.MAX_VALUE, 20));
    	
    	JPanel spaceLeft = new JPanel();
    	spaceLeft.setPreferredSize(new Dimension(50, 0));
    	
    	JPanel spaceRight = new JPanel();
    	spaceRight.setPreferredSize(new Dimension(50, 0));
    	
    	JPanel messageInputPanel = new JPanel(new BorderLayout());
    	textField = new JTextField();
    	sendButton = new JButton("Send");
    	messageInputPanel.add(textField, BorderLayout.CENTER);
    	messageInputPanel.add(sendButton, BorderLayout.EAST);
    	sendButton.addActionListener(e -> {
    		if(userInfo != null) {
    			if(!textField.getText().isEmpty() || !textField.getText().isBlank()) {
    				sendMessage();
    			} else {
    				JOptionPane.showMessageDialog(Frame.this, "Please enter a message before sending.", "Connection", JOptionPane.WARNING_MESSAGE);
    			}
    		} else {
    			JOptionPane.showMessageDialog(Frame.this, "You're not connected.", "Connection", JOptionPane.WARNING_MESSAGE);
    		}
    	});
    	
    	final JButton fileButton = new JButton();
    	fileButton.addActionListener(e -> {
            if(userInfo != null) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(Frame.this);
                if (option == JFileChooser.APPROVE_OPTION) {
                    sendFileMessage(fileChooser.getSelectedFile());
                }
            } else {
                JOptionPane.showMessageDialog(Frame.this, "You're not connected.", "Connection", JOptionPane.WARNING_MESSAGE);
            }
        });

    	fileButton.setIcon(getImage("src/main/resources/img/files.png", 24));
    	messageInputPanel.add(fileButton, BorderLayout.WEST);
    	
    	panel.add(spaceTop, BorderLayout.NORTH);
    	panel.add(spaceLeft, BorderLayout.WEST);
    	panel.add(spaceRight, BorderLayout.EAST);
    	panel.add(messageInputPanel, BorderLayout.CENTER);
    	panel.add(spaceBottom, BorderLayout.SOUTH);
    	
    	contentPanel.add(panel, BorderLayout.SOUTH);
    }
}
