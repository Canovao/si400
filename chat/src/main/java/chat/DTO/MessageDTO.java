package chat.DTO;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The MessageDTO class represents a data transfer object for exchanging messages in a chat application.
 * It includes information such as the sender's username, message content, date and time of the message,
 * and optionally a file attachment with its content.
 */
public class MessageDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String username;
    private final String message;
    private final String dateTimeOfMessage;
    private File file;
    private byte[] fileContent;

    /**
     * Constructs a MessageDTO for a text message.
     *
     * @param username          The username of the message sender.
     * @param message           The content of the text message.
     * @param dateTimeOfMessage The date and time when the message was sent.
     */
    public MessageDTO(String username, String message, Date dateTimeOfMessage) {
        this.username = username;
        this.message = message;
        SimpleDateFormat ft = new SimpleDateFormat("E hh:mm a");
        this.dateTimeOfMessage = ft.format(dateTimeOfMessage);
        this.file = null;
    }

    /**
     * Constructs a MessageDTO for a message with a file attachment.
     *
     * @param username          The username of the message sender.
     * @param dateTimeOfMessage The date and time when the message was sent.
     * @param file              The attached file.
     * @param fileContent       The content of the attached file.
     */
    public MessageDTO(String username, Date dateTimeOfMessage, File file, byte[] fileContent) {
        this.username = username;
        this.fileContent = fileContent;
        this.message = "";
        SimpleDateFormat ft = new SimpleDateFormat("E hh:mm a");
        this.dateTimeOfMessage = ft.format(dateTimeOfMessage);
        this.file = file;
    }

    public String getUsername() {
        return this.username;
    }

    public String getMessage() {
        return this.message;
    }

    public String getDateTimeOfMessage() {
        return this.dateTimeOfMessage;
    }

    public File getMessageFile() {
        return this.file;
    }

    public byte[] getFileContent() {
        return fileContent;
    }
}
