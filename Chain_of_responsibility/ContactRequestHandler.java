package Chain_of_responsibility;

public class ContactRequestHandler extends RequestHandler {

    @Override
    public void approve(Message message) {
        if (message.getType().equals(MessageType.CONTACT)) {
            System.out.println("Contact request approved.");
        } else {
            System.out.println("Message couldn't be approved at contact request.");
            this.getNextHandler().approve(message);
        }
    }

}
