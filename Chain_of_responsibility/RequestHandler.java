package Chain_of_responsibility;

public abstract class RequestHandler {
    private RequestHandler nextHandler;

    public void approve(Message message) {
        if (nextHandler != null) {
            nextHandler.approve(message);
        }
    }

    public void setNextHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public RequestHandler getNextHandler() {
        return nextHandler;
    }

}
