package Junior_java_develop.TASK5.VolatileWork;

public class VolatileMain {
    static int i;

    public static void main(String[] args) {
        new MyThreadRead().start();
        new MyThreadWrite().start();

    }

    static class MyThreadWrite extends Thread{
        @Override
        public void run() {
            while (i < 5) {
                System.out.println("increment i to " + (++i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class MyThreadRead extends Thread{
        @Override
        public void run() {
            int localVar = i;
            while (localVar < 5) {
                if (localVar != i) {
                    System.out.println("new value of i is " + i);
                    localVar = i;
                }
            }
        }
    }
}
