package sample;

import java.util.*;

public class Sample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // given the values, double the even numbers and total
        int result = 0;

        for (int e : numbers) {
            if (e % 2 == 0) {
                result += e * 2;
            }
        }

        System.out.println(result);

        TimeIt.code(() ->
                System.out.println(
                        numbers.parallelStream()
                                .filter(e -> e % 2 == 0)
                                .mapToInt(Sample::compute)
                                .sum()
                ));
    }

    public static int compute(int num) {
        // assume this is time intensive
        try { Thread.sleep(1000); } catch (Exception ex) {}

        return num * 2;
    }

    public class TimeIt {
        public static void code (Runnable block) {
            long start = System.nanoTime();

            try {
                block.run();
            } finally {
                long end = System.nanoTime();
                System.out.println("Time taken(s): " + (end - start) / 1.0e9);
            }
        }
    }
}
