package chat.GUI.dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import chat.GUI.Frame;
import chat.GUI.Constants;

import java.awt.*;

public class AboutDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public AboutDialog(JFrame parent) {
        super(parent, "About", true);
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridLayout(6, 1));

        JLabel nicolas = new JLabel(Constants.NICOLAS);
        nicolas.setIcon(Frame.getImage("src/main/resources/img/nicolas.jpg", 64));
        JLabel thiago = new JLabel(Constants.THIAGO);
        thiago.setIcon(Frame.getImage("src/main/resources/img/thiago.png", 64));
        JLabel eduardo = new JLabel(Constants.EDUARDO);
        eduardo.setIcon(Frame.getImage("src/main/resources/img/eduardo.png", 64));
        JLabel paulo = new JLabel(Constants.PAULO);
        paulo.setIcon(Frame.getImage("src/main/resources/img/paulo.png", 64));
        JLabel daniel = new JLabel(Constants.DANIEL);
        daniel.setIcon(Frame.getImage("src/main/resources/img/daniel.png", 64));

        JLabel aboutText = new JLabel(Constants.ABOUT_TEXT);
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
