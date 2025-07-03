package org.coreconcepts.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableEx {
    public static void main(String[] args) {
        Callable<String> callable = () -> "Hey i am callable I will return a value";
        Callable<List<Integer>> numberListTask  = () -> List.of(23,45,67,68);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> stringFuture = executorService.submit(callable);
        Future<List<Integer>> numberListFuture  = executorService.submit(numberListTask);
        String result = null;
        List<Integer> list = null;
        try {
            result = stringFuture.get();
            list = numberListFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }

        System.out.println(result);
        System.out.println(list);

        // If I use java 19
//        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
//            Future<String> messageFuture = executor.submit(callable);
//            Future<List<Integer>> numberListFuture = executor.submit(numberListTask);
//
//            String message = messageFuture.get();
//            List<Integer> numbers = numberListFuture.get();
//
//            System.out.println(message);
//            System.out.println(numbers);
//
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt(); // preserve interrupt status
//            throw new RuntimeException("Thread was interrupted", e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException("Task execution failed", e);
//        }
    }


}
