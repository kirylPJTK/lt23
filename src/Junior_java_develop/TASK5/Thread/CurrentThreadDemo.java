package Junior_java_develop.TASK5.Thread;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println("Teкyщий поток исполнения : " + t);

        t.setName("My thread");

        System.out.println("Пocлe изменения имени потока: " + t) ;


        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Глaвный поток исполнения прерван");
        }
    }
}
