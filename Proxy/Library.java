package Proxy;

import java.util.HashMap;

public class Library {
    public HashMap<Integer, Document> documents = new HashMap<>();

    public void addDocument(RealDocument document) {
        documents.put(document.id, document);
    }

    public void addProtectedDocument(DocumentProxy document, String username) {
        documents.put(document.getDocumentId(), document);
        AccessControlService.getInstance().grantAccess(document.getDocumentId(), username);
    }

    public Document getDocument(int id) {
        return documents.get(id);
    }

}
