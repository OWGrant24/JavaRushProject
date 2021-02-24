package JavaRush.JavaRush_Projects.Chat;

import java.io.Serializable;

public class Message implements Serializable { //Message - класс, отвечающий за пересылаемые сообщения.
    private final MessageType type; // будет содержать тип сообщения.
    private final String data; //будет содержать данные сообщения.

    public Message(MessageType type) {
        this.type = type;
        this.data = null;
    }

    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }

    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}
