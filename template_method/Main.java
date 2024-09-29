package template_method;

public class Main {
    public static void main(String[] args) {
        DiceGame diceGame = new DiceGame();
        diceGame.play(5);

        RaceGame game = new RaceGame();
        game.play(5);
    }
}
