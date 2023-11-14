package Junior_java_develop.TASK7.MethoData2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class Meta {
    @MyAnno(str = "Example of annotation", val = 100)
    public static void MyMethod() {
        Meta ob = new Meta();

        try{
            Class<?> c = ob.getClass();
            Method m = c.getMethod("MyMethod");
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() +  " " + anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println("NO SUCH METHOD");
        }
        System.out.println(ob.getClass());
        System.out.println();
    }

    public static void main(String[] args) {
        MyMethod();
    }

}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}

