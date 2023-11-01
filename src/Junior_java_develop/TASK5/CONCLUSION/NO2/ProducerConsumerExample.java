package Junior_java_develop.TASK5.CONCLUSION.NO2;

import java.util.Queue;
import java.util.LinkedList;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int capacity = 5;

        Thread producer = new Thread(new Producer(queue, capacity));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {
    private Queue<Integer> queue;
    private int capacity;

    public Producer(Queue<Integer> queue, int capacity) {
        this.queue = queue;
        this.capacity = capacity;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == capacity) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int item = (int) (Math.random() * 100);
                queue.add(item);
                System.out.println("Produced: " + item);
                queue.notify();
            }
        }
    }
}

class Consumer implements Runnable {
    private Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int item = queue.poll();
                System.out.println("Consumed: " + item);
                queue.notify();
            }
        }
    }
}
