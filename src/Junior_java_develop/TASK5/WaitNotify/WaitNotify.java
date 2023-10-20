package Junior_java_develop.TASK5.WaitNotify;

public class WaitNotify {
    public static void main(String[] args) {
        ThreadB threadB = new ThreadB();
        threadB.start();
        synchronized (threadB){
            try {
                threadB.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(threadB.total);

    }
    static class ThreadB extends Thread{
        int total;
        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    total += i;
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                notify();
            }
        }
    }
}


