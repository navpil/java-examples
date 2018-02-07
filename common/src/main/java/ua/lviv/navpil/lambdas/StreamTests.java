package ua.lviv.navpil.lambdas;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamTests {

    public static void main(String[] args) {

        Stream.iterate(new Person(), person -> person);

        Stream.generate(new Supplier<Object>() {
            private int a = 0;
            @Override
            public Object get() {
                return a++;
            }
        }).limit(100).forEach(System.out::println);
    }

    private static class Person {

    }
}
