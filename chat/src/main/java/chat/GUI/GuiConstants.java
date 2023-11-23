package chat.GUI;

public class GuiConstants {
	public static final String autor1 = "Nícolas Canova Berton de Almeida | RA: 172885";
	
	public static final String name = "A3 - Chatting App";
	public static final String version = "v1.0.0";

	private GuiConstants(){}
	
	static String getNameVersion() {
		return (name + " - " + version);
	}
}
