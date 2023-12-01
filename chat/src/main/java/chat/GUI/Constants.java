package chat.GUI;

/**
 * The Constants class contains constant values used throughout the chat application.
 * It includes information such as developer names, application name, version, about text, and help content.
 */
public class Constants {
	/**
	 * Developer information for Nícolas Canova Berton de Almeida.
	 */
	public static final String NICOLAS = "Nícolas Canova Berton de Almeida | RA: 260857";

	/**
	 * Developer information for Thiago Luiz Garcia Gregio.
	 */
	public static final String THIAGO = "Thiago Luiz Garcia Gregio | RA: 257615";

	/**
	 * Developer information for Paulo Henrique De Souza Pantaleão.
	 */
	public static final String PAULO = "Paulo Henrique De Souza Pantaleão | RA: 248437";

	/**
	 * Developer information for Eduardo Longhi.
	 */
	public static final String EDUARDO = "Eduardo Longhi | RA: 237468";

	/**
	 * Developer information for Daniel Menezes.
	 */
	public static final String DANIEL = "Daniel Menezes | RA: 260774";

	/**
	 * The name of the chat application.
	 */
	public static final String NAME = "A3 - Chatting App";

	/**
	 * The version of the chat application.
	 */
	public static final String VERSION = "v1.0.0";

	/**
	 * The combined name and version of the chat application.
	 */
	public static final String NAME_VERSION = NAME + " - " + VERSION;

	/**
	 * The about text containing the application name, version, and developer information.
	 */
	public static final String ABOUT_TEXT = NAME_VERSION + " Created by: ";

	/**
	 * HTML-formatted help content providing instructions on how to start a chat.
	 */
	public static final String HELP_HTML = "<html>" + NAME + "<br> <br> To start a chat go to: <br> File -> Add Connection </html>";

	/**
	 * Private constructor to prevent instantiation of the Constants class.
	 */
	private Constants() {
	}
}
