package chat.GUI.dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import chat.GUI.Constants;

import java.awt.FlowLayout;

public class HelpDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public HelpDialog(JFrame parent) {
        super(parent, "Help", true);
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new FlowLayout());
        JLabel label = new JLabel(Constants.HELP_HTML);
        add(label);
        setSize(300, 150);
        setLocationRelativeTo(null);
    }
}
