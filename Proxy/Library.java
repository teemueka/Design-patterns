package Proxy;

import java.util.HashMap;

public class Library {
    public HashMap<Integer, Document> documents = new HashMap<>();

    public void addDocument(String content) {
        RealDocument realDocument = new RealDocument(content);
        documents.put(realDocument.id, realDocument);
    }

    public void addProtectedDocument(String content, String username) {
        String modified = content;
        modified += ", owner: " + username;
        DocumentProxy documentProxy = new DocumentProxy(new RealDocument(modified));
        documents.put(documentProxy.getDocumentId(), documentProxy);
        AccessControlService.getInstance().grantAccess(documentProxy.getDocumentId(), username);
    }

    public Document getDocument(int id) {
        return documents.get(id);
    }

}
