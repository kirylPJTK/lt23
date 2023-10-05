package Junior_java_develop.TASK5.Thread;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("thread main");
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("thread 0");
    }
}
