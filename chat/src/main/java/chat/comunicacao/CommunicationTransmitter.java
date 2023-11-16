package chat.comunicacao;

import java.io.*;

public class CommunicationTransmitter {
    private final ChatConnection chatConnection;

    public CommunicationTransmitter(ChatConnection chatConnection) {
        this.chatConnection = chatConnection;
    }

    public void enviarMensagem(String mensagem) throws IOException {
        chatConnection.enviarMensagem(mensagem);
    }
}
