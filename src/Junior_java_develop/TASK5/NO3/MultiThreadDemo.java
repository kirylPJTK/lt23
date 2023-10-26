package Junior_java_develop.TASK5.NO3;

public class MultiThreadDemo {
    public static void main(String[] args) {
        new NewMultiThread("Thread 1");
        new NewMultiThread("Thread 2");
        new NewMultiThread("Thread 3");
        // New threads

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Main Thread error");
        }
        System.out.println("Main Thread finished");

    }
}

class NewMultiThread implements Runnable {
    String name;
    Thread t;
    NewMultiThread(String threadName) {
        this.name = threadName;
        t = new Thread(this, name);
        System.out.println("New Thread" + t);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println(name + "ERROR");
        }
        System.out.println(name + " finished");
    }
}