package Junior_java_develop.TASK5.SynchronizedCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollection {
    public static void main(String[] args) {
        NameList nameList = new NameList();
        nameList.add("First");

        class MyThread extends Thread{
            @Override
            public void run() {
                System.out.println(nameList.removeFirst());
            }
        }
        MyThread myThread = new MyThread();
        myThread.setName("one");
        myThread.start();
        new MyThread().start();

    }
    static class NameList {
        private List list = Collections.synchronizedList(new ArrayList<>());

        public void add(String name) {
            list.add(name);
        }

        public synchronized String removeFirst(){
            if (Thread.currentThread().getName().equals("one")){
                Thread.yield();
            }
            if (list.size() > 0) {
                return (String)list.remove(0);
            }
            return null;
        }
    }

}
