package Chain_of_responsibility;

public class Message {
    private final MessageType type;
    private final String messageContent;
    private final String email;

    public Message(MessageType type, String messageContent, String email) {
        this.type = type;
        this.messageContent = messageContent;
        this.email = email;
    }

    public MessageType getType() {
        return type;
    }
    public String getMessageContent() {
        return messageContent;
    }
    public String getEmail() {
        return email;
    }
}
