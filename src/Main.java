import java.util.Arrays;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        IntegerListImpl list = new IntegerListImpl();

        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            list.add(random.nextInt(100000));
        }


        Integer[] copy1 = list.toArray();
        Integer[] copy2 = Arrays.copyOf(copy1, copy1.length);
        Integer[] copy3 = Arrays.copyOf(copy1, copy1.length);


        long start1 = System.currentTimeMillis();
        list.sort(copy1, 0, copy1.length - 1);
        System.out.println("Quick sort time: " + (System.currentTimeMillis() - start1) + " ms");

        long start2 = System.currentTimeMillis();
        Arrays.sort(copy2);
        System.out.println("Arrays.sort time: " + (System.currentTimeMillis() - start2) + " ms");

        long start3 = System.currentTimeMillis();
        Arrays.binarySearch(copy3, random.nextInt(100000));
        System.out.println("Binary search time: " + (System.currentTimeMillis() - start3) + " ms");
    }

    }
