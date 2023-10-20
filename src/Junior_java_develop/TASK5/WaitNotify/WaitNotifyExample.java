package Junior_java_develop.TASK5.WaitNotify;

public class WaitNotifyExample {
    public static void main(String[] args) {
        final Object lock = new Object();

        Thread producer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Producer: Producing data...");
                try {
                    lock.wait(); // Ожидаем уведомления от потребителя
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Producer: Data consumed.");
            }
        });

        Thread consumer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Consumer: Waiting for data...");
                lock.notify(); // Уведомляем производителя
                try {
                    Thread.sleep(1000); // Имитируем обработку данных
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Consumer: Data received.");
            }
        });

        producer.start();
        consumer.start();
    }
}

