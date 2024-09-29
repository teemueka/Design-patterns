package template_method;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RaceGame extends Game {

    private final Scanner input = new Scanner(System.in);
    private boolean gameOver = false;
    private final List<Car> cars = new ArrayList<>();
    private Car winner;

    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.println("Race game starting with " + numberOfPlayers + " players");
        System.out.println("First player at 1000m wins");
        for (int i = 0; i < numberOfPlayers; i++) {
            cars.add(new Car(i));
        }
    }

    @Override
    public boolean endOfGame() {
        return gameOver;
    }

    @Override
    public void playSingleTurn(int player) {
        if (player == 0) {
            System.out.println("You have " + cars.get(0).getCurrency() + " $");
            System.out.println("1. Repair.");
            System.out.println("2. Fuel.");
            System.out.println("3. Drive.");
            System.out.println("4. Change tires.");
            int choice = input.nextInt();
            if (choice == 1 || choice == 2 || choice == 3 || choice == 4) {
                Car user = cars.get(0);
                user.decision(choice);
                user.status();
                if (user.getDistance() >= 1000) {
                    winner = user;
                    gameOver = true;
                }
            } else {
                System.out.println("Invalid choice");
            }
        } else {
            Car bot = cars.get(player);
            bot.decision(3);
            if (bot.getDistance() >= 1000) {
                winner = bot;
                gameOver = true;
            }
        }
    }

    @Override
    public void displayWinner() {
        if (winner != null) {
            System.out.println(winner.getDriver() == 0 ? "You win!" :
                    "Car " + winner.getDriver() + " wins!");
        }
    }
}
