package Async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executor = Executors.newFixedThreadPool(1);
//        Future<Integer> future = executor.submit(() -> Delay.run(2));
//
//        System.out.println("Future done? " + future.isDone());
//
//        int result = future.get();
//
//        System.out.println("Future done? " + future.isDone());
//        System.out.println("Result: " + result);
//
//        executor.shutdown();



        // CODE FOR the processResultAsync method
        final ExecutorService executor = Executors.newSingleThreadExecutor();

        processResultAsync(
                () -> new ArrayList<Long>(Arrays.asList(1L, 2L, 3L, 5L, 5L)),
                executor,
                System.out::println,
                Throwable::printStackTrace
        );


    }

    /* This method:
     1. Takes an executor service
     2. Gets the result from a supplier
     3. Wraps it inside of a try-catch block
     4. OnSuccess - accepts in try, onFail - accepts in catch */
    public static void processResultAsync(
            Supplier<List<Long>> supplier,
            ExecutorService executor,
            Consumer<List<Long>> onSuccess,
            Consumer<Throwable> onFail)
    {
        executor.submit(() -> {
           try {
               List<Long> lines = supplier.get();
               onSuccess.accept(lines);
           } catch (Exception e) {
               onFail.accept(e);
           }
        });
    }

//    public class Delay {
//        public static int run(int num) {
//            try {
//                Thread.sleep(2000);
//
//                return num;
//            } catch (Exception e) {
//                return -1;
//            }
//        }
//    }
}
