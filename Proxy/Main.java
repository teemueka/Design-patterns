package Proxy;

import java.nio.file.AccessDeniedException;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("John Doe");
        User user2 = new User("John Smith");

        Library library = new Library();

        library.addDocument("Unprotected content");
        library.addProtectedDocument("Protected content", user1.username());
        library.addProtectedDocument("Protected content", user2.username());

        try {
            System.out.println("Both users accessing unprotected document");
            System.out.println(user1.username() + " trying to access document: " + library.getDocument(0).getContent(user1));
            System.out.println(user2.username() + " trying to access document: " + library.getDocument(0).getContent(user2));

            System.out.println("\nBoth users accessing protected document 1");
            System.out.println(user1.username() + " trying to access document 1: " + library.getDocument(1).getContent(user1));
            System.out.println(user2.username() + " trying to access document 1: " + library.getDocument(1).getContent(user2));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nBoth users accessing protected document 2");
        try {
            System.out.println(user2.username() + " trying to access document 2: " + library.getDocument(2).getContent(user2));
            System.out.println(user1.username() + " trying to access document 2: " + library.getDocument(2).getContent(user1));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }

    }
}
