package State;

public class IntermediateLevel extends State{

    public IntermediateLevel(Character character) {
        super(character);
    }

    @Override
    void action() {
        if (character.getExperience() >= 40) {
            character.setState(new ExpertLevel(character));
            System.out.println("\nAdvancing to expert level...\n");
            return;
        }
        this.character.getStatus();
        String[] options = {"Train", "Meditate"};
        switch (character.getUserChoice(options)) {
            case 1 -> character.train();
            case 2 -> character.meditate();
        }
    }
}
