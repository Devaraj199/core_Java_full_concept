package org.coreconcepts.thread;

import java.util.concurrent.Exchanger;

public class ExChangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread t1 = new Thread(()->{
            System.out.println("Thread 1...");
            try {
                String response = exchanger.exchange("Hello I am thread" + Thread.currentThread().getName());
                System.out.println("Message from thread 2 ..."+response);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(()->{
            System.out.println("Thread 2...");
            try {
               String response =  exchanger.exchange("Hello I am thread" + Thread.currentThread().getName());
                System.out.println("Message from thread 1 ..."+response);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t3 = new Thread(()->{
            System.out.println("Let see ...");
            try {
                String response =  exchanger.exchange( Thread.currentThread().getName());
                System.out.println("Lets watch ..."+response);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Main thread ....");
    }
}
