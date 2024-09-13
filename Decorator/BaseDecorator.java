package Decorator;

import java.io.IOException;

public abstract class BaseDecorator implements IPrinter {
    private final IPrinter printer;

    public BaseDecorator(IPrinter printer) {
        this.printer = printer;
    }

    @Override
    public void print(String text) throws IOException {
        printer.print(text);
    }

}
