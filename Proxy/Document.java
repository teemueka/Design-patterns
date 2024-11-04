package Proxy;

import java.nio.file.AccessDeniedException;

public interface Document {
    String getContent(User user) throws AccessDeniedException;
}