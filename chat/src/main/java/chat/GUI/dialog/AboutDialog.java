package chat.GUI.dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import chat.GUI.ChatFrame;
import chat.GUI.GuiConstants;

import java.awt.*;

public class AboutDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public AboutDialog(JFrame parent) {
        super(parent, "About", true);
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridLayout(6, 1));

        JLabel nicolas = new JLabel(GuiConstants.NICOLAS);
        nicolas.setIcon(ChatFrame.getImage("src/main/resources/img/nicolas.jpg", 64));
        JLabel thiago = new JLabel(GuiConstants.THIAGO);
        thiago.setIcon(ChatFrame.getImage("src/main/resources/img/thiago.png", 64));
        JLabel eduardo = new JLabel(GuiConstants.EDUARDO);
        eduardo.setIcon(ChatFrame.getImage("src/main/resources/img/eduardo.png", 64));
        JLabel paulo = new JLabel(GuiConstants.PAULO);
        paulo.setIcon(ChatFrame.getImage("src/main/resources/img/paulo.png", 64));
        JLabel daniel = new JLabel(GuiConstants.DANIEL);
        daniel.setIcon(ChatFrame.getImage("src/main/resources/img/daniel.png", 64));

        JLabel aboutText = new JLabel(GuiConstants.ABOUT_TEXT);
        add(aboutText);
        add(nicolas);
        add(thiago);
        add(eduardo);
        add(paulo);
        add(daniel);

        setSize(400, 400);
        setLocationRelativeTo(null);
    }
}
