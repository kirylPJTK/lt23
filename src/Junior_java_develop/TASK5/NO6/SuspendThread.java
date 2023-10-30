package Junior_java_develop.TASK5.NO6;

public class SuspendThread {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");

        try{
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Pause Thread One");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Continue Thread One");
            ob2.mysuspend();
            System.out.println("Pause Thread Two");
            Thread.sleep(1000);
            ob2.myresume();
            System.out.println("Continue Thread Two");
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }

        try {
            System.out.println("Wait to finish threads");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }

        System.out.println("Main thread finished");
    }
}

class NewThread implements Runnable{
    String name;
    Thread t;
    boolean suspendFlag = false;

    public NewThread(String threadName) {
        this.name = threadName;
        t = new Thread(this, name);
        System.out.println("New thread" + t);
        suspendFlag = false;
        t.start();
    }

    @Override
    public void run() {
        try{
            for (int i = 15; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag){
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " ERROR");
        }
        System.out.println(name + " Finished");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}
