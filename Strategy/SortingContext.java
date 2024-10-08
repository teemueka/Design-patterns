package Strategy;

public class SortingContext {
    private SortingStrategy sortingStrategy;

    public SortingContext(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void setSortingStrategy(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(int[] arr) {
        int[] arrCopy = arr.clone();
        long startTime = System.nanoTime();
        sortingStrategy.sort(arrCopy);
        long endTime = System.nanoTime();
        System.out.println("Elapsed time: " + (endTime - startTime) + " ns, used strategy: " + sortingStrategy.getClass().getSimpleName());
    }
}
