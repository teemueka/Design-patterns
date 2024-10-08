package Strategy;

import java.util.Random;

public class RandomArray {
    public int[] generate(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100000);
        }
        return arr;
    }
}
