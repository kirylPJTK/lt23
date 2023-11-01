package Junior_java_develop.TASK5.NO7;

public class State {
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");

        try{
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }

        System.out.println("Stop working");

    }
}

class NewThread implements Runnable{
    String name;
    Thread t;

    public NewThread(String threadName) {
        this.name = threadName;
        this.t = new Thread(this, name);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 15; i > 0; i--) {
            System.out.println(name + ": " + i);

            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println("ERROR");
            }
        }
    }
}
