package builder;

import java.util.ArrayList;

public class Computer {
    public ArrayList<Component> components = new ArrayList<>();

    public Computer() {}

    public void addComponent(Component component) {
        components.add(component);
    }

    public void getComponents() {
        for (Component component : components) {
            System.out.println(component.type);
        }
    }
}
