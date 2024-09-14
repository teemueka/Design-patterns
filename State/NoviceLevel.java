package State;

public class NoviceLevel extends State {

    public NoviceLevel(Character character) {
        super(character);
    }

    @Override
    void action() {
        if (character.getExperience() >= 20) {
            character.setState(new IntermediateLevel(character));
            System.out.println("\nAdvancing to intermediate level...\n");
            return;
        }
        this.character.getStatus();
        String[] options = {"Train"};
        switch (character.getUserChoice(options)) {
            case 1 -> character.train();
        }
    }
}
