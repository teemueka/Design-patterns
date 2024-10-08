package Strategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RandomArray array = new RandomArray();
        int[] small = array.generate(30);
        int[] large = array.generate(100000);

        SortingContext sortingContext = new SortingContext(new Bubblesort());

        System.out.println("small array");
        sortingContext.sort(small);

        sortingContext.setSortingStrategy(new SelectionSort());
        sortingContext.sort(small);

        sortingContext.setSortingStrategy(new OddEvenSort());
        sortingContext.sort(small);

        System.out.println("large array");
        sortingContext.setSortingStrategy(new Bubblesort());
        sortingContext.sort(large);

        sortingContext.setSortingStrategy(new SelectionSort());
        sortingContext.sort(large);

        sortingContext.setSortingStrategy(new OddEvenSort());
        sortingContext.sort(large);
    }
}
