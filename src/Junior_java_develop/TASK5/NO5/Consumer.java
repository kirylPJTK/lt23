package Junior_java_develop.TASK5.NO5;

public class Consumer implements Runnable{
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    @Override
    public void run() {

        while (true) {
            q.get();
        }
    }
}
