package Junior_java_develop.TASK5.Thread;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.start();
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("new Thread");
    }
}
