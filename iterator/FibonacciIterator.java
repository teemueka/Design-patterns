package iterator;

import java.util.Iterator;


public class FibonacciIterator implements Iterator<Integer> {
    private int current = 1;
    private int next = 1;
    private int remaining; // num of elements left to generate

    // constructor initializes the limit
    public FibonacciIterator(int limit) {
        this.remaining = limit;
    }

    // check if more numbers to generate
    @Override
    public boolean hasNext() {
        return remaining > 0;
    }

    // generate next, update state and decrement remaining
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements in the sequence");
        }
        int result = current;
        int newNext = current + next;
        current = next;
        next = newNext;
        remaining--;
        return result;
    }
}