package Junior_java_develop.TASK5.NO5;

public class PC {
    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);

        System.out.println("For stop press Ctrl-C");
    }
}
