package chat;

import java.io.Serializable;

public class MessageDTO implements Serializable {
    private String sender;
    private String message;

    public MessageDTO(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }
}

