package Junior_java_develop.ThreadStaticImports;

public class ThreadPrblems2 {
    public static void main(String[] args) {
        Resource.i = 5;

        MyThread myThread1 = new MyThread();
        myThread1.setName("one");

        MyThread myThread2 = new MyThread();


        myThread1.start();
        myThread2.start();

        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Resource.i);
    }
}

class MyThread extends Thread {
    Resource resource;

    @Override
    public void run() {
//        resource.changeI();
        Resource.changeStaticI();
    }
}

class Resource {
    static int i;

    public synchronized static void changeStaticI() {
        int i = Resource.i;
        if (Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        i++;
        Resource.i = i;
    }

//    public synchronized void changeI() {
//        int i = this.i;
//        if (Thread.currentThread().getName().equals("one")) {
//            Thread.yield();
//        }
//
//        i++;
//
//        this.i = i;
//    }
}