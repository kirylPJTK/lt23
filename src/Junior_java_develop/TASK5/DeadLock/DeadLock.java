package Junior_java_develop.TASK5.DeadLock;

public class DeadLock {
    public static void main(String[] args) {
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
        resourceA.resourceB = resourceB;
        resourceB.resourceA = resourceA;
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        myThread1.resourceA = resourceA;
        myThread2.resourceB = resourceB;
        myThread1.start();
        myThread2.start();

    }
}

class MyThread1 extends Thread {
    ResourceA resourceA;

    @Override
    public void run() {
        System.out.println(resourceA.getI());
    }
}

class MyThread2 extends Thread {
    ResourceB resourceB;

    @Override
    public void run() {
        System.out.println(resourceB.getI());
    }
}

class ResourceA {
    ResourceB resourceB;
    public synchronized int getI() {

        return resourceB.returnI();
    }

    public synchronized int returnI(){
        return 1;
    }
}

class ResourceB {
    ResourceA resourceA;

    public synchronized int getI() {
        return resourceA.returnI();
    }

    public synchronized int returnI(){
        return 2;
    }
}
