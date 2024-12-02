package iterator;

import java.util.Iterator;

public class FibonacciSequence implements ISequence {
    private final int limit; // how many numbers the sequence generates

    public FibonacciSequence(int limit) {
        this.limit = limit;
    }

    // each iterator maintains its own state
    // multiple iterators can traverse the same sequence
    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(limit);
    }
}
