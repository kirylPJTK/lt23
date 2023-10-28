package Junior_java_develop.TASK5.NO4;

import java.sql.SQLOutput;

public class SynThread {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller("Welcome", target);
        Caller ob2 = new Caller("to synchronized", target);
        Caller ob3 = new Caller("world!", target);

        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }
    }
}

class Callme {
    public void call(String msg) {
        synchronized (this) {
            System.out.print("[" + msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("ERROR");
            }
            System.out.println("]");
        }
    }
}

class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;

    public Caller(String msg, Callme target) {
        this.msg = msg;
        this.target = target;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        target.call(msg);
    }
}
