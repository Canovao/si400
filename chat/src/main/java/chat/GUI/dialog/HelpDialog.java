package chat.GUI.dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import chat.GUI.Constants;

import java.awt.FlowLayout;

/**
 * The HelpDialog class represents a dialog box displaying help information for the chat application.
 * It includes a label with HTML-formatted help content.
 */
public class HelpDialog extends JDialog {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a HelpDialog.
     *
     * @param parent The parent JFrame to which the dialog is attached.
     */
    public HelpDialog(JFrame parent) {
        super(parent, "Help", true);
        initializeUI();
    }

    /**
     * Initializes the UI components of the HelpDialog.
     * Sets up a FlowLayout and adds a JLabel containing HTML-formatted help content.
     */
    private void initializeUI() {
        setLayout(new FlowLayout());
        JLabel label = new JLabel(Constants.HELP_HTML);
        add(label);
        setSize(300, 150);
        setLocationRelativeTo(null);
    }
}
