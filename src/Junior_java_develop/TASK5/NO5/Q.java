package Junior_java_develop.TASK5.NO5;

public class Q {
    int n;

    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet)
        try {
            wait();
        } catch (InterruptedException e){
            System.out.println("Exception was catched ");
        }

        System.out.println("We get: " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int n){
        while (valueSet)
        try{
            wait();
        } catch (InterruptedException e) {
            System.out.println("Exception was catched ");
        }
        this.n = n;
        valueSet = true;
        System.out.println("We send: " + n);
        notify();
    }


}
