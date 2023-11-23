package chat.GUI;

import javax.swing.SwingUtilities;

public class ChatApp {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
        	try {
        		ChatFrame frame = new ChatFrame();
        		frame.start();
        	
        	} catch (Exception e) {
				System.err.println(e.getMessage());
        	}
    	});
    }
}
