package State;

public class MasterLevel extends State {

    public MasterLevel(Character character) {
        super(character);
    }

    @Override
    void action() {
        this.character.gameOver();
    }
}
