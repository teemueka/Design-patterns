package prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
        CopyController.getInstance().addRecommendation(this);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void display() {
        System.out.println(targetAudience);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void changeTargetAudience(String newAudience) {
        targetAudience = newAudience;
    }

    @Override
    public Recommendation clone() throws CloneNotSupportedException {
        Recommendation recommendation = (Recommendation) super.clone();
        recommendation.books = new ArrayList<>();
        for (Book book : books) {
            recommendation.books.add((Book) book.clone());
        }
        CopyController.getInstance().addRecommendation(recommendation);
        return recommendation;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String toString() {
        return "Recommendation = { targetAudience: " + targetAudience + ", books: " + books + "]";
    }
}
