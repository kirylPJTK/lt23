package Junior_java_develop.TASK5.NO2;

import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadWithLockExample {
    public static void main(String[] args) {
        // Создаем общий ресурс
        SharedResource sharedResource = new SharedResource();

        // Создаем и запускаем два потока, которые будут работать с общим ресурсом
        Thread thread1 = new MyThread("Поток 1", sharedResource);
        Thread thread2 = new MyThread("Поток 2", sharedResource);

        thread1.start();
        thread2.start();
    }
}

class SharedResource {
    private ReentrantLock lock = new ReentrantLock();

    public void accessResource(String threadName) {
        lock.lock(); // Захватываем блокировку
        try {
            // Критическая секция: обращение к общему ресурсу
            System.out.println(threadName + " начал работу с общим ресурсом.");
            Thread.sleep(1000); // Симулируем работу
            System.out.println(threadName + " закончил работу с общим ресурсом.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // Освобождаем блокировку
        }
    }
}

class MyThread extends Thread {
    private SharedResource sharedResource;

    public MyThread(String name, SharedResource sharedResource) {
        super(name);
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.accessResource(getName());
    }
}
