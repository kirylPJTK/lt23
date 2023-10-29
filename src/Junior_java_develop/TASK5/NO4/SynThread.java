package Junior_java_develop.TASK5.NO4;


public class SynThread {
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Welcome");
        Caller ob2 = new Caller(target, "to synchronized");
        Caller ob3 = new Caller(target, "world!");


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
    synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    String msg;
    Callme target;
    Thread t;

    public Caller(Callme targ, String s) {
        this.target = targ;
        this.msg = s;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
//        synchronized (target){
            target.call(msg);
//        }
    }
}
