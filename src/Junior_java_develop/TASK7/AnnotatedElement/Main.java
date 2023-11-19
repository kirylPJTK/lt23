package Junior_java_develop.TASK7.AnnotatedElement;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class Main {
    @MyAnno()
    public static void myMeth() {
        Main ob = new Main();

        try{
            Class<?> c = ob.getClass();

            Method m = c.getMethod("myMeth");

            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " " + anno.val());
        } catch(NoSuchMethodException e) {
            System.out.println("NO SUCH METHOD");
        }
    }
    public static void main(String[] args) {
        myMeth();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str() default "Testing";
    int val() default 9000;

}
