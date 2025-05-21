package org.coreconcepts.thread;

public class ThreadCommunication {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();
        Thread thread1  = new Thread(()-> {
            synchronized (sharedResource){
                sharedResource.count++;
                System.out.println("Thread 1 incremented count: "+sharedResource.count);
            }
        });
        Thread thread2 = new Thread(() -> {
            synchronized (sharedResource){
                sharedResource.count++;
                System.out.println("Thread 2 incremented count: "+sharedResource.count);
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Thread is completed");
    }
}

class SharedResource {
    int count = 0;
}
