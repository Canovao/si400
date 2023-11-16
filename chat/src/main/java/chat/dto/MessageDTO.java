package chat.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable {
    private final String remetente;
    private final String destinatario;
    private final String conteudo;

    public MessageDTO(String remetente, String destinatario, String conteudo) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.conteudo = conteudo;
    }

    public String getRemetente() {
        return remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getConteudo() {
        return conteudo;
    }
}
