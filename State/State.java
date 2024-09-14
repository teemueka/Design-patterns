package State;

public abstract class State {
    protected Character character;

    public State(Character character) {
        this.character = character;
    }

    abstract void action();
}
