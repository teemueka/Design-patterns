package Proxy;

import java.nio.file.AccessDeniedException;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("John Doe");
        User user2 = new User("John Smith");

        Library library = new Library();

        RealDocument unprotectedDocument = new RealDocument("Unprotected content");
        DocumentProxy protectedDocument1 = new DocumentProxy(new RealDocument("Protected content by Doe"));
        DocumentProxy protectedDocument2 = new DocumentProxy(new RealDocument("Protected content by Smith"));

        library.addDocument(unprotectedDocument);
        library.addProtectedDocument(protectedDocument1, user1.username());
        library.addProtectedDocument(protectedDocument2, user2.username());

        System.out.println("Both users accessing unprotected document");
        System.out.println(user1.username() + " trying to access document: " + unprotectedDocument.getContent(user1));
        System.out.println(user2.username() + " trying to access document: " + unprotectedDocument.getContent(user2));

        System.out.println("\nBoth users accessing protected document 1");
        try {
            System.out.println(user1.username() + " trying to access document 1: " + protectedDocument1.getContent(user1));
            System.out.println(user2.username() + " trying to access document 1: " + protectedDocument1.getContent(user2));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nBoth users accessing protected document 2");
        try {
            System.out.println(user2.username() + " trying to access document 2: " + protectedDocument2.getContent(user2));
            System.out.println(user1.username() + " trying to access document 2: " + protectedDocument2.getContent(user1));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

    }
}
