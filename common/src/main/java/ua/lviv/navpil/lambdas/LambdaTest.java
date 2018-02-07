package ua.lviv.navpil.lambdas;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.StreamSupport;

public class LambdaTest {

    public static void main(String[] args) {

        One a = new One() {
            @Override
            public void a() {
                c();
            }
        };
        new Three().aa(a);

        new Three().aa((One)() -> System.out.println("asdf"));

//        new Thread(a::a);

        ArrayList<Integer> integers1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers1.add(i);
        }

        integers1.stream().reduce("", (carry, e) -> carry + e, (s1, s2) -> s1 + s2);


        Numbers integers = new Numbers();
//        for (Integer integer : integers) {
//            System.out.println(integer);
//            if (integer == 100) {
//                break;
//            }
//        }

        StreamSupport.stream(integers.spliterator(), false).limit(100).forEach(System.out::println);


    }


    public static class Three {

        public void aa (One a) {
            a.a();
        }

        public void aa (Two b) {
            b.b();
        }

    }

    public interface One {
        void a();

        default void c() {
            System.out.println("c");
        }
    }

    public interface Two {

        void b();
    }

    public static class Numbers implements Iterable<Integer> {

        @Override
        public Iterator<Integer> iterator() {
            return new NumberIterator();
        }

        private static class NumberIterator implements Iterator<Integer> {

            private int i = 0;

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return i++;
            }
        }
    }

}
