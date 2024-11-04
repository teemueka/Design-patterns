package Proxy;

import java.util.Date;

public class RealDocument implements Document {
    public static int globalId = -1;
    public final int id;
    public Date creationDate;
    private final String content;

    public RealDocument(String content) {
        globalId++;
        this.id = globalId;
        this.creationDate = new Date();
        this.content = content;
    }

    @Override
    public String getContent(User user) {
        return content;
    }
}
