package Decorator;

public class BasicPrinter implements IPrinter{

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
