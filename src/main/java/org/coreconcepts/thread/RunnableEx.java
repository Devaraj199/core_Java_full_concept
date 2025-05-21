package org.coreconcepts.thread;

import java.util.concurrent.*;

public class RunnableEx {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("I am runnable executing");
        };
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(runnable);
        executor.shutdown();

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
