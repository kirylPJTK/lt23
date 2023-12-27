package Junior_java_develop.TASK7.MethoData6;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnnos.class)
@interface MyAnno{
    String str() default "Testing";
    int val() default 9000;
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnnos{
    MyAnno[] value();
}

class RepeatAnno {

    @MyAnno(str = "First annotation", val = -1)
    @MyAnno(str = "Second annotation", val = 100)
    public static void MyMeth(String str, int i){
        RepeatAnno ob = new RepeatAnno();

        try {
            Class<?> c = ob.getClass();
            Method m = c.getMethod("MyMeth", String.class, int.class);
            Annotation[] annos = m.getAnnotationsByType(MyAnno.class);
            for(Annotation a : annos)
                System.out.println(a);

        }catch (NoSuchMethodException exc) {
            System.out.println("Method is not found");
        }
    }

    public static void main(String[] args) {
        MyMeth("test", 10);
    }
}
