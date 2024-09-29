package template_method;

import java.util.Scanner;

public class Car {

    private final int driver;
    private int currency = 1000;
    private int distance;

    private int wear = 0;
    private int fuel = 100;
    private int speed = 0;

    public enum TireType {
        NORMAL,
        IMPROVED,
        RACE
    }

    private final Scanner input = new Scanner(System.in);
    private TireType tires = TireType.NORMAL;

    public Car(int player) {
        this.driver = player;
    }

    public int getDistance() {
        return distance;
    }

    public int getCurrency() {
        return currency;
    }

    public int getDriver() {
        return driver;
    }

    public TireType getTires() {
        return tires;
    }

    public void drive() {
        if (this.wear >= 100) {
            repair();
            return;
        }
        if (this.fuel <= 0) {
            reFuel();
            return;
        }
        switch (getTires()) {
            case NORMAL:
                speed = 60;
                fuel -= 10;
                wear += 10;
                distance += speed;
                break;
                case IMPROVED:
                    speed = 80;
                    fuel -= 5;
                    wear += 15;
                    distance += speed;
                    break;
                    case RACE:
                        speed = 100;
                        fuel -= 15;
                        wear += 20;
                        distance += speed;
                        break;
        }
    }

    public void repair() {
        if (this.wear >= 100) {
            int cost = this.wear * 10;
            if (cost > this.currency) {
                flipBurgers();
            } else {
                this.currency -= this.wear * 10;
                this.wear = 0;
            }
        }
    }

    public void reFuel() {
        if (!(this.fuel >= 100)) {
            int cost = ((100 - this.fuel) * 5);
            if (cost > this.currency) {
                flipBurgers();
            } else {
                this.currency -= cost;
                this.fuel = 100;
            }
        }
    }

    public void flipBurgers() {
        this.currency += 500;
    }

    public void changeTires() {
        int choice;
        System.out.println("1. Improved tires, 500$");
        System.out.println("2. Race tires, 800$");
        System.out.println("0. Exit");

        choice = input.nextInt();

        switch (choice) {
                case 1:
                    if (currency >= 500) {
                        tires = TireType.IMPROVED;
                        currency -= 500;
                    }
                    break;
                case 2:
                    if (currency >= 800) {
                        tires = TireType.RACE;
                        currency -= 800;
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
    }


    public void decision(int choice) {
        switch (choice) {
            case 1:
                repair();
                break;
            case 2:
                reFuel();
                break;
            case 3:
                drive();
                break;
            case 4:
                changeTires();
                break;
            default:
                decision(choice);
                break;
        }
    }

    public void status() {
        System.out.println("\nFuel: " + fuel + "l");
        System.out.println("Wear: " + wear + "%");
        System.out.println("Distance: " + distance + "km");
        System.out.println("Speed: " + speed + " km/h\n");
    }
}
