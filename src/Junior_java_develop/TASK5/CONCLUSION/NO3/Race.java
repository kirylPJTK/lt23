package Junior_java_develop.TASK5.CONCLUSION.NO3;

public class Race {
    public static void main(String[] args) {
        Resource resource = new Resource();
        resource.i = 5;
        Mythread myThread1 = new Mythread();

        Mythread myThread2 = new Mythread();


        myThread1.setResource(resource);
        myThread2.setResource(resource);

        // Сначала запускаем оба потока
        myThread1.start();
        myThread2.start();

        System.out.println(resource.i);
    }
}

class Mythread extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
    }
}

class Resource {
    int i;

    public void changeI() {
        int i = this.i;


        i++;
        this.i = i;
    }
}
