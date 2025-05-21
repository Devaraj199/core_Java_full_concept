package org.coreconcepts.thread;

public class WaitNotifyExample {
    public static void main(String[] args) throws InterruptedException {
        Message message = new Message();
        Thread writer = new Thread(() -> {
            synchronized (message){
                System.out.println("Writer is writing...");
                message.content = "I am writing";
                message.notify();
            }
        });

        Thread reader = new Thread(() ->{
            synchronized (message) {
                try {
                    message.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Reader got message: " + message.content);
            }
        });

        reader.start();
        Thread.sleep(100);
        writer.start();
        writer.join();
        reader.join();
        System.out.println("Main thread going to call last");
    }
}

class  Message {
    String content ;
}
