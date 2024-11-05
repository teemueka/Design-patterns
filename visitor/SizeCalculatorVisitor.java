package visitor;

import java.util.ArrayList;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double totalSize = 0;

    @Override
    public void visit(File file) {
        System.out.println("Filename: " + file.fileName + ", Filesize: " + file.fileSize + "MB");
        totalSize += file.fileSize;
        System.out.println("Total size: " + totalSize);
    }

    @Override
    public void visit(Directory directory) {
        ArrayList<FileSystemElement> elements = directory.getElements();
        System.out.println("\nOpening root directory...");
        if (!elements.isEmpty()) {
            System.out.println("Structure:\n");
            for (FileSystemElement element : elements) {
                if (element instanceof Directory) {
                    System.out.println(element.getClass().getSimpleName());
                    unpackSubDir((Directory) element, 1);
                } else if (element instanceof File) {
                    System.out.println(element.getClass().getSimpleName() + ", size: " + ((File) element).fileSize);
                    totalSize += ((File) element).fileSize;
                }
            }
        } else {
            System.out.println("Directory does not contain any elements");
        }
        System.out.println("\nTotal size: " + totalSize);
        totalSize = 0;
    }

    public void unpackSubDir(Directory dir, int indentLevel) {
        if (!dir.getElements().isEmpty()) {
            for (FileSystemElement element : dir.getElements()) {
                if (element instanceof Directory) {
                    System.out.println("\t".repeat(indentLevel) + element.getClass().getSimpleName());
                    unpackSubDir((Directory) element, indentLevel + 1);
                } else if (element instanceof File) {
                    System.out.println("\t".repeat(indentLevel) + element.getClass().getSimpleName() + ", size: " + ((File) element).fileSize);
                    totalSize += ((File) element).fileSize;
                }
            }
        } else {
            System.out.println("\t".repeat(indentLevel) + "Directory does not contain any elements");
        }
    }

}
