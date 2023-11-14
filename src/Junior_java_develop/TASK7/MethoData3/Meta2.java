package Junior_java_develop.TASK7.MethoData3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class Meta2 {
    @MyAnno(str = "Two parametrs", val = 19)
    public static void myMeth(String str,int i) {
        Meta2 ob = new Meta2();

        try{
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth", String.class, int.class);
            MyAnno anno = m.getAnnotation(MyAnno.class);
            System.out.println(anno.str() + " "  + anno.val());
        } catch (NoSuchMethodException e) {
            System.out.println("NO SUCH METHOD");
        }
    }

    public static void main(String[] args) {
        myMeth("Test", 10);
    }

}
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}
