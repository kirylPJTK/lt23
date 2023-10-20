package Junior_java_develop.TASK5.AtomicVariables;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariables {
    static AtomicInteger atomicInteger = new AtomicInteger(0) ;

    public static void main(String[] args) {
        for (int j = 0; j < 10000; j++) {
            new MyThreadA().start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(atomicInteger.get());
    }

    static class MyThreadA extends Thread{
        @Override
        public void run() {
            atomicInteger.incrementAndGet();
        }
    }
}
