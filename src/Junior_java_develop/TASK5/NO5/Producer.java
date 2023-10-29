package Junior_java_develop.TASK5.NO5;

public class Producer implements Runnable{
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Provider").start();
    }

    @Override
    public void run() {
        int i = 0;

        while (true) {
            q.put(i++);
        }
    }
}
