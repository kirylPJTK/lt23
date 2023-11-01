package Junior_java_develop.TASK5.CONCLUSION.NO2;

public class SynThread {
    public static void main(String[] args) {
        Count c = new Count();

        new Plus(c);
        new Minus(c);

    }
}

class Plus implements Runnable{
    Count c;

    public Plus(Count c) {
        this.c = c;
        new Thread(this, "Plus").start();
    }

    @Override
    public void run() {
        c.plus();
    }
}

class Minus implements Runnable{

    Count c;

    public Minus(Count c) {
        this.c = c;
        new Thread(this, "Minus").start();
    }

    @Override
    public void run() {
        c.minus();
    }
}

class Count {
    int i;

    synchronized int plus() {
        System.out.println(i++);
        return i;
    }

    synchronized int minus() {
        System.out.println(i--);
        return i;
    }
}


