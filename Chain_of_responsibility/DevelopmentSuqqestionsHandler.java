package Chain_of_responsibility;

public class DevelopmentSuqqestionsHandler extends RequestHandler {

    @Override
    public void approve(Message message) {
        if (message.getType().equals(MessageType.DEVELOPMENT)) {
            System.out.println("Message approved, suggestion forwarded to development team.");
        } else {
            System.out.println("Message couldn't be approved.");
        }
    }
}
