package SynechronForMS;

/*
Question:

Write a Java program that uses three threads to print a sequence of numbers up to a given number N.
Each thread should take turns printing the numbers in order, ensuring that the sequence follows a round-robin pattern
among the three threads. For example, if N is 10, the output should look like this:
THREAD-1 : 1
THREAD-2 : 2
THREAD-3 : 3
THREAD-1 : 4
THREAD-2 : 5
THREAD-3 : 6
THREAD-1 : 7
THREAD-2 : 8
THREAD-3 : 9
THREAD-1 : 10
 */

//public class NumberPrinter implements Runnable{
public class NumberPrinter {

    private static final int N = 10; // Specify the upper limit of the sequence
    private static final int NUM_THREADS = 3; // Number of threads

    private int current = 1; // Current number to be printed
    private int threadToRun = 1; // Which thread should run next

    /*@Override
    public void run() {
        int threadId = Integer.parseInt(Thread.currentThread().getName());
        printNumbers(threadId);
    }*/

    synchronized void printNumbers(int threadId) {
        while (current <= N) {
            while (threadToRun != threadId) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }

            if (current <= N) {
                System.out.println("THREAD-" + threadId + " : " + current);
                current++;
            }

            threadToRun = (threadToRun % NUM_THREADS) + 1; // Update the next thread to run
            notifyAll(); // Wake up all threads
        }
    }

    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();
        //Thread task = new Thread(numberPrinter);

        /*Runnable task = new Runnable() {
            @Override
            public void run() {
                int threadId = Integer.parseInt(Thread.currentThread().getName());
                numberPrinter.printNumbers(threadId);
            }
        };
        */

        //Since Runnable is a Functional interface with only run() method. we can write above code as follows
        //Or we can also make our class implement Runnable and provide run() method like in line 31
        //and create new Thread using NumberPrinter object like in line 59.
        Runnable task = () -> {
            int threadId = Integer.parseInt(Thread.currentThread().getName());
            numberPrinter.printNumbers(threadId);
        };

        // Create and start threads
        for (int i = 1; i <= NUM_THREADS; i++) {
            Thread thread = new Thread(task, String.valueOf(i));
            thread.start();
        }
    }
}