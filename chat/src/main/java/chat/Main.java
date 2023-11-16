package chat;

import chat.comunicacao.ChatConnection;
import chat.gui.ChatWindow;
import chat.gui.ConnectionDialog;
import chat.comunicacao.CommunicationReceiver;

public class Main {
    public static void main(String[] args) {
        ChatWindow chatWindow = new ChatWindow();

        ConnectionDialog connectionDialog = new ConnectionDialog(chatWindow);
        connectionDialog.setVisible(true);

        String ip = connectionDialog.getIP();
        int porta = connectionDialog.getPorta();

        try {
            ChatConnection chatConnection = new ChatConnection(ip, porta);

            chatWindow.adicionarMensagem("Conexão estabelecida com sucesso.");
            chatWindow.adicionarMensagem("Agora você pode começar a conversar.");

            Thread receptorThread = new Thread(new CommunicationReceiver(chatConnection));
            receptorThread.start();

            chatWindow.setVisible(true);
        } catch (Exception e) {
            chatWindow.adicionarMensagem("Erro ao estabelecer a conexão: " + e.getMessage());
        }
    }
}
