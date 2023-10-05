package Junior_java_develop.TASK5.Thread;

public class YieldExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable("Поток 1"));
        Thread thread2 = new Thread(new MyRunnable("Поток 2"));

        thread1.start();
        thread2.start();
    }
}

class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": Шаг " + i);
//            Thread.yield(); // Уступаем процессорное время
        }
    }
}
