package visitor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<FileSystemElement> elements = new ArrayList<>();
        //Files not in directory
        elements.add(new File("filecoffeefile", 1000));
        elements.add(new File("file2", 2000));
        elements.add(new File("file3", 3000));

        //Directory with files and subdirectories
        Directory directory = new Directory();
        directory.addElement(new File("file4", 1000));
        Directory subDirectory = new Directory();
        subDirectory.addElement(new File("coffeefile", 2000));
        subDirectory.addElement(new File("file6", 3000));
        Directory subDirectory2 = new Directory();
        subDirectory2.addElement(new File("filecoffee", 4000));

        subDirectory.addElement(subDirectory2);
        directory.addElement(subDirectory);

        elements.add(directory);


        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();

        System.out.println("\nSTARTING SIZE CALCULATOR VISITOR\n");
        for (FileSystemElement element : elements) {
            element.accept(sizeCalculatorVisitor);
        }

        SearchVisitor searchVisitor = new SearchVisitor();

        System.out.println("\nSTARTING SEARCH VISITOR\n");
        for (FileSystemElement element : elements) {
            element.accept(searchVisitor);
        }
    }
}
