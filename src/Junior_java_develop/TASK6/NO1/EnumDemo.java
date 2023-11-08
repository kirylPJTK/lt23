package Junior_java_develop.TASK6.NO1;

public class EnumDemo {
    public static void main(String[] args) {
        Apple ap;

        ap = Apple.RedDel;

        System.out.println("ap :" + ap);
        System.out.println();

        ap = Apple.GoldenDel;

        if (ap == Apple.GoldenDel)
            System.out.println("ap include GoldenDel.\n");

        Apple apples[] = Apple.values();

        for (Apple a : apples) {
            System.out.println(a.getPrice());
        }

        ap = Apple.valueOf("Winesap");
        System.out.println("ap = " + ap);

        System.out.println(Apple.Jonathan.ordinal());

       Apple ap1, ap2, ap3;

       for (Apple a : Apple.values()) {
           System.out.println(a + " " + a.ordinal());
       }

       ap1 = Apple.RedDel;
       ap2 = Apple.GoldenDel;
       ap3 = Apple.RedDel;

        System.out.println(

        );

        if (ap1.compareTo(ap2) < 0)
            System.out.println("ap1 < ap2");

        if (ap1.compareTo(ap2) > 0)
            System.out.println("ap1 > ap2");
        if(ap1.compareTo(ap3) == 0)
            System.out.println(ap1 + " equals " + ap3);
        if (ap1.equals (ap2) )
            System . out . println ( "Error ! " ) ;
        if (ap1.equals (ap3) )
            System.out.println(ap1 + " equals " + ap3);
        if(ap1 == ap3)
            System.out.println((ap1 + " == " + ap3));



    }
}


















