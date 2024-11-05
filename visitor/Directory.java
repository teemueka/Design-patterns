package visitor;

import java.util.ArrayList;

public class Directory implements FileSystemElement {

    private final ArrayList<FileSystemElement> elements = new ArrayList<>();

    public Directory() {}

    public ArrayList<FileSystemElement> getElements() {
        return elements;
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
