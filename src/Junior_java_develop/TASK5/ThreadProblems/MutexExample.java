package Junior_java_develop.TASK5.ThreadProblems;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Создаем два потока
        Thread thread1 = new Thread(new Worker(counter));
        Thread thread2 = new Thread(new Worker(counter));

        // Запускаем потоки
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Count: " + counter.getCount());
    }
}

class Counter {
    private int count = 0;
    private Lock lock = new ReentrantLock(); // Создаем мьютекс

    public int getCount() {
        return count;
    }

    public void increment() {
        lock.lock(); // Захватываем мьютекс
        try {
            count++; // Увеличиваем счетчик
        } finally {
            lock.unlock(); // Освобождаем мьютекс в finally блоке
        }
    }
}

class Worker implements Runnable {
    private Counter counter;

    public Worker(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.increment();
        }
    }
}
