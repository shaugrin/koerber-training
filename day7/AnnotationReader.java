package day7;
import java.lang.annotation.*;
import java.lang.reflect.*;

public class AnnotationReader {

    public static void readAnnotation(AnnotatedElement element) {
        Annotation[] annotations = element.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof Author author) {
                System.out.println("Author: " + author.name());
            } else if (annotation instanceof Version version) {
                System.out.println("Version: " + version.number());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Reading class-level annotations:");
        readAnnotation(AnnotatedClass.class);

        System.out.println("\nReading annotations for annotatedMethod1:");
        try {
            Method method1 = AnnotatedClass.class.getMethod("annotatedMethod1");
            readAnnotation(method1);
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        }

        System.out.println("\nReading annotations for annotatedMethod2:");
        try {
            Method method2 = AnnotatedClass.class.getMethod("annotatedMethod2");
            readAnnotation(method2);
        } catch (NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }
}
