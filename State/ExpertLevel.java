package State;

public class ExpertLevel extends State {

    public ExpertLevel(Character character) {
        super(character);
    }

    @Override
    void action() {
        if (character.getExperience() >= 60) {
            character.setState(new MasterLevel(character));
            return;
        }
        this.character.getStatus();
        String[] options = {"Train", "Meditate", "Fight"};
        switch (character.getUserChoice(options)) {
            case 1 -> character.train();
            case 2 -> character.meditate();
            case 3 -> character.fight();
        }
    }
}
