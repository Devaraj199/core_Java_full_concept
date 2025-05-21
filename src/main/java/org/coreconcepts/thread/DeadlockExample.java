package org.coreconcepts.thread;

public class DeadlockExample {
    private static final Object RESOURCE_A = new Object();
    private static final Object RESOURCE_B = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (RESOURCE_A) {
                System.out.println("Thread 1: Locked resource A");

                try {
                    Thread.sleep(100); // Delay to ensure the other thread has time to lock resource B
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 1: Waiting for resource B");
                synchronized (RESOURCE_B) {
                    System.out.println("Thread 1: Locked resource B");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (RESOURCE_B) {
                System.out.println("Thread 2: Locked resource B");

                try {
                    Thread.sleep(100); // Delay to ensure the other thread has time to lock resource A
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread 2: Waiting for resource A");
                synchronized (RESOURCE_A) {
                    System.out.println("Thread 2: Locked resource A");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}

