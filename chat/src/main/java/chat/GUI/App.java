package chat.GUI;

import chat.connection.Connection;

import javax.swing.SwingUtilities;

/**
 * The App class is the entry point of the chat application.
 * It initializes the graphical user interface (GUI) and starts the server for handling incoming connections.
 */
public class App {
	/**
	 * The main method that launches the chat application.
	 *
	 * @param args Command-line arguments (not used in this application).
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				Frame frame = new Frame();
				frame.start();

				// Start the server in a separate thread
				new Thread(() -> Connection.startServer()).start();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		});
	}
}
