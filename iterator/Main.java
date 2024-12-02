package iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        FibonacciSequence sequence = new FibonacciSequence(10);
        Iterator<Integer> itr = sequence.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
