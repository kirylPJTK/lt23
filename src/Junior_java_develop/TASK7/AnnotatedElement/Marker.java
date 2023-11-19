package Junior_java_develop.TASK7.AnnotatedElement;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class Marker {

    @MyMarker
    public static void myMeth() {
        Marker ob = new Marker();

        try {
            Method m = ob.getClass().getMethod("myMeth");

            if (m.isAnnotationPresent(MyMarker.class))
                System.out.println("Annotation marker is present");
        } catch (NoSuchMethodException e) {
            System.out.println("NO SUCH METHOD");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}


@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker{}