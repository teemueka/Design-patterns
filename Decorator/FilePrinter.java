package Decorator;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter extends BaseDecorator{

    private final FileWriter fileWriter;

    public FilePrinter(IPrinter printer) throws IOException {
        super(printer);
        this.fileWriter = new FileWriter("FileDecorator");
    }

    @Override
    public void print(String text) throws IOException {
        fileWriter.write(text);
        fileWriter.close();
    }
}
