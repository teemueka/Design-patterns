package template_method;

import java.util.Random;
import java.util.Scanner;

public class DiceGame extends Game {

    Random rand = new Random();
    private final Scanner input = new Scanner(System.in);
    private boolean gameOver = false;
    private int currentPlayer;
    private int turn;

    @Override
    public void initializeGame(int numberOfPlayers) {
        System.out.println("Dice game initializing...");
        System.out.println("The first player to score the same face value wins..");
    }

    @Override
    public boolean endOfGame() {
        return gameOver;
    }

    @Override
    public void playSingleTurn(int player) {
        if (player == 0) {
            this.turn++;
            System.out.println("\nROUND " + turn);
            do {
                System.out.print("Press enter to play your turn.\n");
            } while (!input.nextLine().isEmpty());
        }
        boolean result = rollDice(player);
        try {
            Thread.sleep(500);
            if (result) {
                gameOver = true;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void displayWinner() {
        System.out.println(this.currentPlayer == 0 ? "You won!\n" : "The winner is player " + currentPlayer + "\n");
    }

    public boolean rollDice(int player) {
        this.currentPlayer = player;
        int roll1 = rand.nextInt(6) + 1;
        int roll2 = rand.nextInt(6) + 1;

        String particapant = player == 0 ? "You rolled: " : "Player " + player + " rolled: ";
        System.out.println(particapant + roll1 + " and " + roll2);

        return roll1 == roll2;
    }
}
