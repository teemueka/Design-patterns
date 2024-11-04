package Proxy;

import java.nio.file.AccessDeniedException;

public class DocumentProxy implements Document  {
    private final RealDocument realDocument;

    public DocumentProxy(RealDocument realDocument) {
        this.realDocument = realDocument;
    }

    @Override
    public String getContent(User user) throws AccessDeniedException{
        if (AccessControlService.getInstance().isAllowed(getDocumentId(), user.username())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.username());
        }
    }

    public int getDocumentId() {
        return realDocument.id;
    }
}
