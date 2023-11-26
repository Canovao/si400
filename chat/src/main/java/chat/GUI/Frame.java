package chat.GUI;

import javax.swing.*;

import chat.connection.ChatClient;
import chat.connection.ChatServer;
import chat.DTO.MessageDTO;
import chat.GUI.dialog.AboutDialog;
import chat.GUI.dialog.ConnectionDialog;
import chat.GUI.dialog.HelpDialog;
import chat.connection.fileTransmission.AudioPlayer;
import chat.connection.fileTransmission.FileSender;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.util.Date;

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

    public static void setUserInfo(MessageDTO userInfo){
        getInstance().userInfo = userInfo;
    }

    public static MessageDTO getUserInfo(){
        return getInstance().userInfo;
    } 

    public Frame() {
        super(Constants.NAME_VERSION);
        instance = this;
        configureFrame();
        createAndAddMenuBar();
        addListenersMenu(this);
        addComponents();
    }
    
    public static Frame getInstance() {
    	return instance;
    }
    
    public void start() {
    	this.setVisible(true);
    } 
    
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
    
    private void addListenersMenu(ActionListener listener) {
    	for(Component menu : this.getJMenuBar().getComponents()) {
    		if(menu instanceof JMenu) {
    			addListenersItemMenu(listener, (JMenu) menu);
    		}
    	}
    }
    
    private void addListenersItemMenu(ActionListener listener, JMenu menu) {
    	for (Component item : menu.getMenuComponents()) {
    		if(item instanceof JMenuItem) {
    			((JMenuItem) item).addActionListener(listener);
    		}
    	}
    }
    
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
            ChatServer.disconnect();
            System.exit(0);
        }
    }
    
    private void addComponents() {
    	addStatusBar();
    	addContentPanel();
    	addConversationArea();
    	addMessageInput();
    }
    
    private void addStatusBar() {
    	JPanel statusPanel = new JPanel();
    	statusPanel.setBackground(Color.white);
    	statusBar = new JLabel("Connection Status: Not Connected");
    	statusPanel.add(statusBar);
    	this.add(statusPanel, BorderLayout.SOUTH);
    }
    
    public void updateConnectionStatus(boolean connected) {
        if (connected) {
            statusBar.setText("Connection: Connected");
        } else {
            statusBar.setText("Connection: Disconnected");
        }
    }
    
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
    
    public String formatMessage(String message) {
        final int MAX_CHARACTERS_PER_LINE = 80;
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

    public void sendMessage() {
    	String message = textField.getText();
    	ChatClient.sendMessage(message);
        addMessageToConversation(new MessageDTO("Eu", message, new Date()));
        textField.setText("");
    }
    
    public void sendFileMessage(File file) {
    	String message = textField.getText();
    	ChatClient.sendFileMessage(new MessageDTO(message, message, new Date(), file));
    	addFileSentMessageToConversation(new MessageDTO("Eu", message, new Date(), file));
    	textField.setText("");
    }
    
    public void addMessageToConversation(MessageDTO receivedMessage) {
        if (receivedMessage.getMessageFile() != null) {
            String fileName = receivedMessage.getMessageFile().getName();
            String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

            SwingUtilities.invokeLater(() -> conversationArea.append(receivedMessage.getUsername() + ":\n" + (receivedMessage.getMessage().isBlank() ? "" : receivedMessage.getMessage() + "\n")));
            if (extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("gif")) {
                ImageIcon imageIcon = new ImageIcon(receivedMessage.getMessageFile().getAbsolutePath());
                Image image = imageIcon.getImage();
                Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                ImageIcon resizedImageIcon = new ImageIcon(resizedImage);

                JLabel imageLabel = new JLabel();
                imageLabel.setIcon(resizedImageIcon);
                conversationArea.add(imageLabel);
            } else if (extension.equalsIgnoreCase("mp3") || extension.equalsIgnoreCase("wav")) {
                JButton audioPlayerButton = new JButton("Play Audio");
                audioPlayerButton.addActionListener(e -> {
                    try {
                        AudioPlayer.playAudio(receivedMessage.getMessageFile().getAbsolutePath());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });
                conversationArea.add(audioPlayerButton);
            } else {
                JLabel fileLabel = new JLabel(fileName);
                conversationArea.add(fileLabel);
            }

            SwingUtilities.invokeLater(() -> conversationArea.append(receivedMessage.getMessageFile().getName() + receivedMessage.getDateTimeOfMessage() + "\n\n"));
        } else {
            String message = receivedMessage.getMessage();
            SwingUtilities.invokeLater(() -> conversationArea.append(receivedMessage.getUsername() + ":" + receivedMessage.getDateTimeOfMessage() + "\n" + formatMessage(message) + "\n\n"));
        }
    }

    
    public void addFileSentMessageToConversation(MessageDTO receivedFileMessage) {
        addMessageToConversation(receivedFileMessage);
        textField.setText("");
    }

    public static ImageIcon getImage(String path, int size){
        ImageIcon originalIcon = new ImageIcon(path);
        Image originalImage = originalIcon.getImage();
        return new ImageIcon(originalImage.getScaledInstance(size, size, Image.SCALE_SMOOTH));
    }

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
                    File selectedFile = fileChooser.getSelectedFile();

                    try {
                        FileSender fileSender = new FileSender(ChatClient.getSocket());
                        fileSender.sendFile(selectedFile.getAbsolutePath());

                        sendFileMessage(selectedFile);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
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
