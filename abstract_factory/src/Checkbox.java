public abstract class Checkbox {
    public String text;

    public Checkbox(String text) {
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public abstract void display();
}
