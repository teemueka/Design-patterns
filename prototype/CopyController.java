package prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyController {
    private boolean running = true;
    private static CopyController instance = null;
    private final List<Recommendation> recommendations = new ArrayList<>();

    private CopyController() {}

    public static CopyController getInstance() {
        if (instance == null) {
            instance = new CopyController();
        }
        return instance;
    }

    public void displayRecommendations() {
        for (int i = 0; i < recommendations.size(); i++) {
            System.out.println(i+1 + ". " + recommendations.get(i));
        }
    }

    public void addRecommendation(Recommendation recommendation) {
        recommendations.add(recommendation);
    }

    public void start() throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"1. Add new recommendation",
                            "2. View recommendations",
                            "3. Exit"};
        do {
            for (String option : options) {
                System.out.println(option);
            }
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.print("Enter the target audience:");
                    String target = scanner.next();
                    new Recommendation(target);
                    System.out.println("new recommendation with " + target + " as target audience has been added");
                    break;
                case 2:
                    if (recommendations.isEmpty()) {
                        System.out.println("No recommendations found!");
                        break;
                    }
                    displayRecommendations();
                    System.out.println("Do you want to select specific recommendation? (y/n)");
                    String answer = scanner.next();
                    if (answer.equalsIgnoreCase("y")) {
                        RecommendationHandling();
                    }
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("shutting down...");
                    running = false;
            }
        } while (running);
    }

    private void RecommendationHandling() throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
        boolean interacting = true;
        System.out.println("Select the recommendation or 0 to exit:");
        displayRecommendations();
        Recommendation recommendation = recommendations.get(scanner.nextInt() - 1);
        while (interacting) {
            String[] options = {"1. Change target audience",
                                "2. Add new book",
                                "3. Remove book",
                                "4. Copy",
                                "5. Return to main menu"};
            for (String option : options) {
                System.out.println(option);
            }
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.print("Enter new target audience:");
                    String target = scanner.next();
                    recommendation.changeTargetAudience(target);
                    System.out.println("Target audience has been changed");
                    break;
                case 2:
                    String author;
                    String title;
                    String genre;
                    int year;
                    System.out.print("Enter author: ");
                    author = scanner.next();
                    System.out.print("Enter title: ");
                    title = scanner.next();
                    System.out.print("Enter genre: ");
                    genre = scanner.next();
                    System.out.print("Enter year: ");
                    year = scanner.nextInt();
                    recommendation.addBook(new Book(author, title, genre, year));
                    System.out.println("New book has been added!");
                    break;
                case 3:
                    System.out.println("Which book would you like to remove?");
                    int i = 0;
                    for (Book book : recommendation.getBooks()) {
                        i++;
                        System.out.println(i + " " + book);
                    }
                    Book bookToRemove = recommendation.getBooks().get(scanner.nextInt() - 1);
                    System.out.println(scanner.nextInt() + " " + bookToRemove);
                    recommendation.removeBook(bookToRemove);
                    System.out.println(bookToRemove + " has been removed!");
                    break;
                case 4:
                    recommendation.clone();
                    System.out.println("Recommendation has been cloned!");
                    break;
                case 5:
                    interacting = false;
                    break;
                default:
                    System.out.println("Returning to main menu...");
                    interacting = false;
            }
        }
    }
}
