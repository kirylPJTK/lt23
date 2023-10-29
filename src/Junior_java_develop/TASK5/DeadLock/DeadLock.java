package Junior_java_develop.TASK5.DeadLock;

import java.util.TreeMap;

public class DeadLock implements Runnable{
    A a = new A();
    B b = new B();

    DeadLock() {
        Thread.currentThread().setName("Main thread");

        Thread t = new Thread(this, "Rival Thread");
        t.start();

        a.foo(b);

        System.out.println("Back to main thread");
    }

    @Override
    public void run() {
        b.bar(a);
        System.out.println("Back to another thread");
    }

    public static void main(String[] args) {
        new DeadLock();
    }
}

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " came to A.foo() method");

        try{
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Class A ERROR");
        }

        System.out.println(name + " try to call B.last() method");
        b.last();

    }

    synchronized void last() {
        System.out.println("In A.last() method");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " came in B.bar() method");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Class B ERROR");
        }

        System.out.println(name + " try to call A.last() method");
        a.last();
    }

    synchronized void last() {
        System.out.println("in A.last() method");
    }
}