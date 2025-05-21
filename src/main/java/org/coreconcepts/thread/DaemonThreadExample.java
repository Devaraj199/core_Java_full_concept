package org.coreconcepts.thread;

    public class DaemonThreadExample {
        public static void main(String[] args) {
            Thread daemonThread = new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("Daemon thread is running...");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread t2 = new Thread(()-> {
                System.out.println("User thread1");
                try {
                    Thread.sleep(50000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            });

            // Set the thread as daemon
            daemonThread.setDaemon(true);

            // Start the daemon thread
            daemonThread.start();
            t2.start();

            // Main thread (user thread) sleeps for 3 seconds and then terminates
            try {
                System.out.println("Main thread is sleeping...");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Main thread is exiting...");
            // When main thread exits, the JVM will terminate the daemon thread and exit
        }
    }

