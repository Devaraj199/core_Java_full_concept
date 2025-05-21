package org.coreconcepts.thread;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadExample {
//    public static void main(String[] args) {
//        // Create a single virtual thread
//        Thread vThread = Thread.ofVirtual().start(() -> {
//            System.out.println("Running in a virtual thread!");
//        });
//
//        try {
//            vThread.join();
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
//
//        // Create many virtual threads using an executor
//        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
//            IntStream.range(0, 10_000).forEach(i -> {
//                executor.submit(() -> {
//                    try {
//                        Thread.sleep(Duration.ofSeconds(1));
//                        return i;
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                });
//            });
//            // The executor auto-closes when exiting the try-block
//        }
//
//        System.out.println("All tasks submitted");
//    }
}

