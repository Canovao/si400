package chat.arquivos;

import java.io.*;

import chat.comunicacao.ChatConnection;

public class FileSender {
    private final ChatConnection chatConnection;

    public FileSender(ChatConnection chatConnection) {
        this.chatConnection = chatConnection;
    }

    public void enviarArquivo(File arquivo) throws IOException {
        FileInputStream fis = new FileInputStream(arquivo);
        BufferedInputStream bis = new BufferedInputStream(fis);

        byte[] buffer = bis.readAllBytes();

        chatConnection.sendBytes(buffer);

        bis.close();
        fis.close();
    }
}
