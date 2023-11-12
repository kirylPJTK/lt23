package Junior_java_develop.TASK7.MethoData;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MyAnnotation {

    public static void main(String[] args) {

    }
    @MyAnno(str = "Annotation Example", val = 100)
    public static void myMeth() {
        // java . lang . annotation . RetentionPolicy
        // SOURCE, CLASS, RUNTIME.
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}
