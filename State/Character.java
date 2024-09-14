package State;

import java.util.Random;
import java.util.Scanner;

public class Character {
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;
    private State state;
    private String name;
    private int experience = 0;
    private int healthPoints = 10;
    Random rand = new Random();

    public Character() {
        state = new NoviceLevel(this);
    }

    public void setState(State state) {
        this.state = state;
    }


    public void start() {
        while (running) {
            if (state == null) {
                System.out.println("Game not available.");
                return;
            }
            if (this.name == null) {
                System.out.print("\nEnter a character name to begin: ");
                this.name = scanner.nextLine();
                System.out.println("Game started... \n");
            }
            state.action();
        }
    }

    public void train() {
        int exp = rand.nextInt(1,11);
        System.out.println(this.name + " gained " + exp + " experience while training");
        this.experience += exp;
    }

    public void meditate() {
        int hp = rand.nextInt(1,11);
        System.out.println(this.name + " gained " + hp + " health points while meditating");
        this.healthPoints += hp;
    }

    public void fight() {
        int hp = rand.nextInt(1,11);
        int exp = rand.nextInt(1,21);
        System.out.println(this.name + " gained " + exp + " experience and lost " + Math.min(hp, this.healthPoints) + " health points while fighting");
        this.experience += exp;
        this.healthPoints -= hp;
        if (this.healthPoints <= 0) {
            gameOver();
        }
    }

    public int getExperience() {
        return this.experience;
    }

    //Stops the game loop and resets to initial values
    public void gameOver() {
        //display ending values
        System.out.println("\nGame over...");
        int HP = Math.max(this.healthPoints, 0);
        if (HP == 0) {
            System.out.println("Player died while fighting.");
        } else {
            System.out.println("Max level reached!");
        }
        System.out.println(this.name + " reached: " + this.state.getClass().getSimpleName());
        System.out.println("Gained experience: " + this.experience);
        System.out.println("Remaining health points: " + HP);

        this.running = false;
        this.state = null;
        this.name = null;
        this.experience = 0;
        this.healthPoints = 10;
    }

    public void getStatus() {
        System.out.println("---------------------");
        System.out.println("Level: " + state.getClass().getSimpleName());
        System.out.println("Character name: " + name);
        System.out.println("Experience: " + experience);
        System.out.println("Health points: " + healthPoints);
        System.out.println("---------------------");
    }

    public int getUserChoice(String[] options) {
        System.out.println("\nSelect an option:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        return scanner.nextInt();
    }
}
