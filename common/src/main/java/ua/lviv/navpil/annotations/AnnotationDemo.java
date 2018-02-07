package ua.lviv.navpil.annotations;

import java.lang.annotation.Annotation;

public class AnnotationDemo {


    public static void main(String[] args) {
        Person person = new Person();

        for (Annotation annotation : Person.class.getAnnotations()) {
            if (annotation.annotationType().equals(MyRuntimeAnnotation.class)) {
                MyRuntimeAnnotation annotation1 = (MyRuntimeAnnotation) annotation;
                System.out.println(annotation1.myValue());
            } else if (annotation.annotationType().equals(MySourceAnnotation.class)) {
                MySourceAnnotation annotation1 = (MySourceAnnotation) annotation;
                System.out.println(annotation1.myValue());

            }
        }
    }

    @MyRuntimeAnnotation(myValue = "Different")
    @MySourceAnnotation
    public static class Person {
    }

}
