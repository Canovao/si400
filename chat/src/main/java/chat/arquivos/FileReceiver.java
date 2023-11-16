package chat.arquivos;

import java.io.IOException;

import chat.comunicacao.ChatConnection;

public class FileReceiver implements Runnable {
    private ChatConnection chatConnection;
    private boolean rodando;

    public FileReceiver(ChatConnection chatConnection) {
        this.chatConnection = chatConnection;
        this.rodando = true;
    }

    @Override
    public void run() {
        try {
            while (rodando) {
                byte[] buffer = chatConnection.receberBytes();
                // Aqui você pode fazer algo com os bytes recebidos, por exemplo, salvar em um arquivo
            }
        } catch (IOException e) {
            // Trate a exceção de acordo com a necessidade (por exemplo, exiba uma mensagem de erro)
            e.printStackTrace();
        }
    }

    public void parar() {
        rodando = false;
    }
}
