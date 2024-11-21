package prototype;

public class Book implements Cloneable {
    private String author;
    private String title;
    private String genre;
    private int publicationYear;


    public Book(String author, String title, String genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    public Book clone() throws CloneNotSupportedException {
        return (Book) super.clone();
    }

    public String toString() {
        return "Book = {" + author + ", " + title + ", " + genre + ", " + publicationYear + "}";
    }
}
