public class ThreadSequence {
    private static final int MAX_NUMBER = 10;
    private static int number = 1;
    private static int threadIdToRun = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(new Printer(1), "Thread 1");
        Thread t2 = new Thread(new Printer(2), "Thread 2");
        Thread t3 = new Thread(new Printer(3), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }

    static class Printer implements Runnable {
        private int threadId;

        public Printer(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (ThreadSequence.class) {
                    if (number > MAX_NUMBER) {
                        break;
                    }

                    // Check if it's this thread's turn
                    if (threadIdToRun != threadId) {
                        try {
                            ThreadSequence.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        // Print the number
                        System.out.println(Thread.currentThread().getName() + " : " + number);
                        number++;

                        // Decide next thread to run
                        threadIdToRun = (threadIdToRun % 3) + 1;

                        // Notify all waiting threads
                        ThreadSequence.class.notifyAll();
                    }
                }
            }
        }
    }
}