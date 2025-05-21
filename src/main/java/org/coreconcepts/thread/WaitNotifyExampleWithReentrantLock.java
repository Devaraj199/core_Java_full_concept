package org.coreconcepts.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WaitNotifyExampleWithReentrantLock {
    public static void main(String[] args) throws InterruptedException {
            Message1 message1 = new Message1();
            MessageHandler handler = new MessageHandler();
            Thread writer = new Thread(()->{
                System.out.println("Writer is writing");
                handler.writeMessage(message1,"I am writing");
            });

        Thread reader = new Thread(()->{
            System.out.println("Reader is writing");
            String msg = handler.readMessage(message1);
            System.out.println("Reader got message: " + msg);
        });

        reader.start();
        writer.start();
        writer.join();
        reader.join();
    }
}

class Message1 {
    String content;
}

class MessageHandler {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition messageAvailable = lock.newCondition();
    private boolean hasMessage = false;
        public void writeMessage(Message1 message1,String msg){
            lock.lock();
            try {
                message1.content = msg;
                hasMessage = true;
                messageAvailable.signal();
            }
           finally {
                lock.unlock();
            }

        }
        public String readMessage(Message1 message1){
            lock.lock();
            try {
                while (!hasMessage) {
                    try {
                        messageAvailable.await();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return null;
                    }
                }
                return message1.content;
            } finally {
                lock.unlock();
            }
        }
}
