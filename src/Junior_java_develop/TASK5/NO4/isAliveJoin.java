package Junior_java_develop.TASK5.NO4;

public class isAliveJoin {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("Thread 1");
        NewThread ob2 = new NewThread("Thread 2");
        NewThread ob3 = new NewThread("Thread 3");

        System.out.println("Thread 1 started " + ob1.t.isAlive());
        System.out.println("Thread 2 started " + ob2.t.isAlive());
        System.out.println("Thread 3 started " + ob3.t.isAlive());


        try{
            System.out.println("Wait for thread finishing");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted");
        }

        System.out.println("Thread 1 started " + ob1.t.isAlive());
        System.out.println("Thread 2 started " + ob2.t.isAlive());
        System.out.println("Thread 3 started " + ob3.t.isAlive());

        System.out.println("Main thread was finished");

    }
}

class NewThread implements Runnable{
    String name;
    Thread t;
    public NewThread(String threadName) {
        this.name = threadName;
        t = new Thread(this, name);
        System.out.println("New Thread" + t);
        t.start();
    }

    @Override
    public void run() {
        try{
            for (int i = 5; i > 0 ; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e) {
            System.out.println(name+ " ERROR ");
        }

        System.out.println(name+ " finished");
    }
}
