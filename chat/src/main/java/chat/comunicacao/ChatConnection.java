package chat.comunicacao;

import java.io.*;
import java.net.*;

public class ChatConnection {
    private final Socket socket;
    private final DataOutputStream out;
    private final DataInputStream in;

    public ChatConnection(String ip, int porta) throws IOException {
        socket = new Socket(ip, porta);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
    }

    public void enviarMensagem(String mensagem) throws IOException {
        out.writeUTF(mensagem);
    }

    public String receberMensagem() throws IOException {
        return in.readUTF();
    }

    public void sendBytes(byte[] buffer) throws IOException {
        out.writeInt(buffer.length);
        out.write(buffer);
    }

    public byte[] receberBytes() throws IOException {
        int tamanho = in.readInt();
        byte[] buffer = new byte[tamanho];
        in.readFully(buffer);
        return buffer;
    }

    public void fecharConexao() throws IOException {
        out.close();
        in.close();
        socket.close();
    }
}
