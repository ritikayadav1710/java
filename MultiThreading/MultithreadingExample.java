// Main Class to demonstrate Multithreading concepts
public class MultithreadingExample {

    // Thread 1: Printing numbers
    static class NumberPrinter extends Thread {
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Number: " + i);
                try {
                    Thread.sleep(500); // Simulating delay
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    // Thread 2: Printing letters using Runnable
    static class LetterPrinter implements Runnable {
        public void run() {
            for (char c = 'A'; c <= 'E'; c++) {
                System.out.println("Letter: " + c);
                try {
                    Thread.sleep(500); // Simulating delay
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    // Thread 3: Demonstrating Synchronization
    static class Counter {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    static class CounterThread extends Thread {
        private Counter counter;

        public CounterThread(Counter counter) {
            this.counter = counter;
        }

        public void run() {
            for (int i = 0; i < 5; i++) {
                counter.increment();
                System.out.println("Counter: " + counter.getCount());
                try {
                    Thread.sleep(500); // Simulating delay
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Thread 1: Start NumberPrinter thread
        NumberPrinter numberPrinter = new NumberPrinter();
        numberPrinter.start();

        // Thread 2: Start LetterPrinter thread
        LetterPrinter letterPrinter = new LetterPrinter();
        Thread letterThread = new Thread(letterPrinter);
        letterThread.start();

        // Thread 3: Start CounterThread demonstrating Synchronization
        Counter counter = new Counter();
        Thread counterThread1 = new CounterThread(counter);
        Thread counterThread2 = new CounterThread(counter);
        counterThread1.start();
        counterThread2.start();

        try {
            // Wait for all threads to finish
            numberPrinter.join();
            letterThread.join();
            counterThread1.join();
            counterThread2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("All threads finished execution.");
    }
}
