package Junior_java_develop.TASK5.CONCLUSION.NO1;

public class TwoThreads {
    public static void main(String[] args) {
        Threads t1 = new Threads("One");
        Threads t2 = new Threads("Two");

        try {
            t1.t.join();
            t2.t.join();
        } catch (InterruptedException e) {
            System.out.println("error");
        }
    }
}

class Threads implements Runnable{
    String name;
    Thread t;

    public Threads(String tname) {
        this.name = tname;
        this.t = new Thread(this, name);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(name + ": " + i);
        }
    }
}
