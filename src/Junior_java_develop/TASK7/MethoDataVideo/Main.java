package Junior_java_develop.TASK7.MethoDataVideo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception{

        Cat myCat = new Cat("Stella");

        Dog myDog = new Dog("Jack");

        if(myCat.getClass().isAnnotationPresent(VeryImportant.class)){
            System.out.println("This thing is very important");
        } else {
            System.out.println("This thing is not very important");
        }

        for (Method method : myCat.getClass().getDeclaredMethods()) {
            if(method.isAnnotationPresent(RunImmediately.class)){
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);

                for(int i = 0; i < annotation.times(); i++){
                    method.invoke(myCat);
                }
            }
        }

        for (Field field : myCat.getClass().getDeclaredFields()){
            if (field.isAnnotationPresent(ImportantString.class)) {
                Object objectValue = field.get(myCat);

                if (objectValue instanceof String stringValue) {
                    System.out.println(stringValue.toUpperCase());
                }
            }
        }
    }
}
