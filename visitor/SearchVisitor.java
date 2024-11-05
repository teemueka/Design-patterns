package visitor;

import java.util.ArrayList;

public class SearchVisitor implements FileSystemVisitor {
    public static final String CRITERIA = "coffee";
    public ArrayList<File> criteriaFiles = new ArrayList<>();


    @Override
    public void visit(File file) {
        if (file.fileName.contains(CRITERIA)) {
            criteriaFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        ArrayList<FileSystemElement> elements = directory.getElements();
        if (!elements.isEmpty()) {
            for (FileSystemElement element : elements) {
                if (element instanceof Directory) {
                    unpackSubDir((Directory) element, 1);
                } else if (element instanceof File) {
                    if (((File) element).fileName.contains(CRITERIA)) {
                        criteriaFiles.add((File) element);
                    }
                }
            }
        } else {
            System.out.println("Directory does not contain any elements");
        }
        getCriteriaFiles();
    }

    public void unpackSubDir(Directory dir, int indentLevel) {
        if (!dir.getElements().isEmpty()) {
            for (FileSystemElement element : dir.getElements()) {
                if (element instanceof Directory) {
                    unpackSubDir((Directory) element, indentLevel + 1);
                } else if (element instanceof File) {
                    if (((File) element).fileName.contains(CRITERIA)) {
                        criteriaFiles.add((File) element);
                    }
                }
            }
        } else {
            System.out.println("\t".repeat(indentLevel) + "Directory does not contain any elements");
        }
    }

    public void getCriteriaFiles() {
        if (!criteriaFiles.isEmpty()) {
            System.out.println("Found " + criteriaFiles.size() + " criteria files");
            for (File file : criteriaFiles) {
                System.out.println(file.fileName + ", size: " + file.fileSize);
            }
        } else {
            System.out.println("No criteria files found");
        }
    }
}
