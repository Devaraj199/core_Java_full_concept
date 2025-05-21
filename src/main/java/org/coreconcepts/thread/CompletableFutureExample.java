package org.coreconcepts.thread;

import java.util.concurrent.*;

public class CompletableFutureExample {
    public static void main(String[] args) {
        // Create a custom executor for our async tasks
        ExecutorService executor = Executors.newFixedThreadPool(5);
        try{
//            basicExample();
//            chainingExample();
//              combiningExample();
            errorHandlingExample();
        }

        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            // Shutdown the executor
            executor.shutdown();
        }
    }

    private static void basicExample() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
           return "Result of the asynchronous computation";
        });

        // Block and get the result
        String result = future.get();
        System.out.println(result);

        // Non-blocking way to process the result
        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> "Another result")
                .thenAccept(s -> System.out.println("Processed asynchronously: " + s));

        // Wait for completion
        future2.join();
    }
    private static void chainingExample() {
        System.out.println("\n--- Chaining Operations Example ---");

        CompletableFuture.supplyAsync(() -> {
            System.out.println("Original task running in thread: " + Thread.currentThread().getName());
            return "Step 1";
        }).thenApply(result -> {
            System.out.println("thenApply running in thread: " + Thread.currentThread().getName());
            return result + " -> Step 2";
        }).thenApply(result -> {
            System.out.println("Another thenApply in thread: " + Thread.currentThread().getName());
            return result + " -> Step 3";
        }).thenAccept(result -> {
            System.out.println("Final result processing in thread: " + Thread.currentThread().getName());
            System.out.println("Final result: " + result);
        }).join();

        // Async variants run in a different thread
        System.out.println("\nUsing async variants:");
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Original async task in thread: " + Thread.currentThread().getName());
            return "Async Step 1";
        }).thenApplyAsync(result -> {
            System.out.println("thenApplyAsync in thread: " + Thread.currentThread().getName());
            return result + " -> Async Step 2";
        }).thenAcceptAsync(result -> {
            System.out.println("thenAcceptAsync in thread: " + Thread.currentThread().getName());
            System.out.println("Final async result: " + result);
        }).join();
    }
    private static void combiningExample() throws ExecutionException, InterruptedException {
        System.out.println("\n--- Combining CompletableFutures Example ---");

        // Create two independent futures
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            delay(1000);
            return "Result from Future 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            delay(2000);
            return "Result from Future 2";
        });

        // Combine results when both are complete
        CompletableFuture<String> combinedFuture = future1.thenCombine(future2,
                (result1, result2) -> result1 + " + " + result2);

        System.out.println("Combined result: " + combinedFuture.get());

        // CompletableFuture.allOf - wait for multiple futures to complete
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            delay(500);
            return "Result from Future 3";
        });

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);

        // Wait for all futures to complete
        allFutures.join();

        // Now we can get all results (futures are already completed)
        System.out.println("All futures completed:");
        System.out.println("Future 1 result: " + future1.get());
        System.out.println("Future 2 result: " + future2.get());
        System.out.println("Future 3 result: " + future3.get());

        // CompletableFuture.anyOf - complete when any of the futures completes
        CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(
                createDelayedFuture("Fast Task", 100),
                createDelayedFuture("Medium Task", 300),
                createDelayedFuture("Slow Task", 500)
        );

        System.out.println("First completed future result: " + anyFuture.get());
    }

    private static CompletableFuture<String> createDelayedFuture(String name, int delayMs) {
        return CompletableFuture.supplyAsync(() -> {
            delay(delayMs);
            return name + " completed after " + delayMs + "ms";
        });
    }

    private static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
    private static void errorHandlingExample() {
        System.out.println("\n--- Error Handling Example ---");

        // Handle exceptions with exceptionally
        CompletableFuture<String> futureWithException = CompletableFuture.supplyAsync(() -> {
            if (true) { // Simulate an error
                throw new RuntimeException("Simulated error");
            }
            return "This will not be returned";
        }).exceptionally(ex -> {
            System.out.println("Exception caught: " + ex.getMessage());
            return "Recovery value";
        });

        System.out.println("Result after exception: " + futureWithException.join());

        // Handle with handle method (for both success and failure cases)
        CompletableFuture<String> futureWithHandle = CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Random error");
            }
            return "Success result";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println("Exception handled: " + ex.getMessage());
                return "Fallback value";
            } else {
                return result;
            }
        });

        System.out.println("Result with handle: " + futureWithHandle.join());

        // whenComplete to perform an action when the future completes (successfully or with exception)
        CompletableFuture.supplyAsync(() -> {
            if (Math.random() > 0.5) {
                throw new RuntimeException("Another random error");
            }
            return "Another success result";
        }).whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Operation completed with exception: " + ex.getMessage());
            } else {
                System.out.println("Operation completed successfully with: " + result);
            }
        }).exceptionally(ex -> {
            // Still need this to handle the exception and provide a value
            return "Recovery value after whenComplete";
        }).join();
    }
}
