package Junior_java_develop.TASK5.NO1;

public class MultiThreadExample {
    public static void main(String[] args) {
        // Создаем и запускаем три потока
        Thread thread1 = new MyThread("Поток 1");
        Thread thread2 = new MyThread("Поток 2");
        Thread thread3 = new MyThread("Поток 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Запущен " + getName());

        try {
            // Поток выполняет какую-то работу здесь
            Thread.sleep(1000); // Подождать 1 секунду (1000 миллисекунд)
        } catch (InterruptedException e) {
            System.out.println(getName() + " прерван.");
        }

        System.out.println(getName() + " завершен.");
    }
}
