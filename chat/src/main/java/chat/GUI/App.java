package chat.GUI;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> {
        	try {
        		Frame frame = new Frame();
        		frame.start();
        	
        	} catch (Exception e) {
				System.err.println(e.getMessage());
        	}
    	});
    }
}
