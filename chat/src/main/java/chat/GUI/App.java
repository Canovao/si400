package chat.GUI;

import chat.connection.Chat;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
        	try {
        		Frame frame = new Frame();
        		frame.start();

				new Thread(() -> Chat.startServer()).start();
        	} catch (Exception e) {
				System.err.println(e.getMessage());
        	}
    	});
    }
}
