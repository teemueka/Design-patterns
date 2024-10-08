package Chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        // Messages
        Message first = new Message(MessageType.CONTACT, "contact me please", "contacting.customer@dp.com");
        Message second = new Message(MessageType.COMPENSATION, "give money back on my vacuum cleaner or else...", "angry.customer@dp.com");
        Message third = new Message(MessageType.DEVELOPMENT, "fix your app", "developement.customer@dp.com");

        // Handlers
        RequestHandler compensationClaimsHandler = new CompensationClaimsHandler();
        RequestHandler contactRequestHandler = new ContactRequestHandler();
        RequestHandler developmentSuggestionHandler = new DevelopmentSuqqestionsHandler();

        // Chain
        compensationClaimsHandler.setNextHandler(contactRequestHandler);
        contactRequestHandler.setNextHandler(developmentSuggestionHandler);

        // Chain start
        compensationClaimsHandler.approve(first);
        System.out.println();
        compensationClaimsHandler.approve(second);
        System.out.println();
        compensationClaimsHandler.approve(third);
    }
}
