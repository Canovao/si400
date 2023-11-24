package chat.GUI.dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import chat.GUI.GuiConstants;

import java.awt.FlowLayout;

public class AboutDialog extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AboutDialog(JFrame parent) {
        super(parent, "About", true);
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new FlowLayout());
        JLabel label = new JLabel(GuiConstants.ABOUT_HTML);
        add(label);
        setSize(300, 200);
        setLocationRelativeTo(null);
    }
}
