package Junior_java_develop.TASK5.ThreadProblems;

public class ThreadProblems {
    public static void main(String[] args) {
        Resource resource = new Resource();
        resource.i = 5;
        Mythread myThread1 = new Mythread();
        myThread1.setName("one");

        Mythread myThread2 = new Mythread();


        myThread1.setResource(resource);
        myThread2.setResource(resource);

        // Сначала запускаем оба потока
        myThread1.start();
        myThread2.start();

        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(resource.i);
    }
}

class Mythread extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
    }
}

class Resource {
    int i;

    public synchronized void changeI() { // Сделаем метод synchronized для безопасности
        int i = this.i;
        if (Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }

        i++;
        this.i = i;
    }
}
