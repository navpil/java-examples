package ua.lviv.navpil.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WhoIsFaster {

    public static void main(String[] args) {
        List<Integer> ints = new LinkedList<>(IntStream.range(1, 1000000).boxed().collect(Collectors.toList()));

        ListIterator<Integer> integerListIterator = ints.listIterator();
        for (int i = 0; i < 500000; i++) {
            integerListIterator.next();
        }
        long l = System.currentTimeMillis();
        for (int i = 0; i < 4000; i++) {
            integerListIterator.add(4);
        }
        System.out.println(System.currentTimeMillis() - l);

        int a = 0;
        for (Integer anInt : ints) {
            a =+ anInt.hashCode();
        }
        System.out.println(a);
    }

}
