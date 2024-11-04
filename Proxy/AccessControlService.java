package Proxy;

import java.util.HashMap;

public final class AccessControlService {

    private static AccessControlService instance;
    private final HashMap<Integer, String> accessControl = new HashMap<>();
    private AccessControlService() {}

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public boolean isAllowed(int docID, String username) {
        if (accessControl.containsKey(docID)) {
            return accessControl.get(docID).equals(username);
        }
        return false;
    }

    public void grantAccess(int docID, String username) {
        accessControl.put(docID, username);
    }
}
