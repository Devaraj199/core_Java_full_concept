package org.coreconcepts.thread;

public class ThreadLifecycleDemo {
    public static void main(String[] args) {
        System.out.println("Main: Creating a new thread...");
        Thread thread = new Thread(() -> {
            System.out.println("Main: Thread is Running...");
        });
        System.out.println("Main: Thread state after creation: " + thread.getState());
        thread.start();
        System.out.println("Main: Thread state after creation: " + thread.getState());

        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main: Interrupted while waiting for thread to finish");
        }
        System.out.println("Main: Thread state after join: " + thread.getState());
    }
}
