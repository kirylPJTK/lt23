package Junior_java_develop.TASK5.NO3;

public class ThreadDemo {
    public static void main(String[] args) {
        new NewThread();

        try{
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Main Thread error");
        }
        System.out.println("Main Thread finished");
    }
}

class NewThread implements Runnable {
    Thread t;
    NewThread() {
        t = new Thread(this, "Demonstration thread");
        System.out.println("Subsidiary thread is ready" + t);
        t.start();
    }

    @Override
    public void run() {

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Subsidiary thread " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e){
            System.out.println("Subsidiary thread error");
        }
        System.out.println("Subsidiary thread finished");
    }
}
