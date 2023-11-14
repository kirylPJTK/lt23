package Junior_java_develop.TASK7.MethoData4;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@What (description = "Аннотация тестового класса" )
@MyAnno(str = "Meta2", val = 99)
public class Meta3 {
    @What(description = "Text class annptation")
    @MyAnno(str = "Meta3", val = 99)
    public static void myMeth() {
        Meta3 ob = new Meta3();

        try{
            Annotation annos[] = ob.getClass().getAnnotations();
            System.out.println("All annotations for Meta3 class");

            for (Annotation a : annos) {
                System.out.print(a + " ");
            }
            System.out.println();

            Method m = ob.getClass().getMethod("myMeth");
            annos = m.getAnnotations();

            System.out.println("All annotations for myMeth() method");
            for (Annotation a : annos) {
                System.out.print(a + " ");
            }
        } catch (NoSuchMethodException e) {
            System.out.println("NO SUCH METHOD");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}
