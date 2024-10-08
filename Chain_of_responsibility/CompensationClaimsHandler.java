package Chain_of_responsibility;

public class CompensationClaimsHandler extends RequestHandler {

    private static final String forbidden = "vacuum cleaner";

    @Override
    public void approve(Message message) {
        if (message.getType().equals(MessageType.COMPENSATION)) {
            if (message.getMessageContent().contains(forbidden)) {
                System.out.println("Compensation not available for " + forbidden);
            } else {
                System.out.println("Compensation claims request approved.");
            }
        } else {
            System.out.println("Message couldn't be approved at compensation claims.");
            this.getNextHandler().approve(message);
        }
    }

}
