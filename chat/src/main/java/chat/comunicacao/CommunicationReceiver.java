package chat.comunicacao;


import java.io.*;

public class CommunicationReceiver implements Runnable {
    private final ChatConnection chatConnection;
    private boolean rodando;

    public CommunicationReceiver(ChatConnection chatConnection) {
        this.chatConnection = chatConnection;
        this.rodando = true;
    }

    @Override
    public void run() {
        try {
            while (rodando) {
                String mensagem = chatConnection.receberMensagem();
                // Aqui você pode fazer algo com a mensagem recebida, por exemplo, exibi-la na interface gráfica
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parar() {
        rodando = false;
    }
}
