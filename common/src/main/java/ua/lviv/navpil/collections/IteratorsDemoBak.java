package ua.lviv.navpil.collections;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IteratorsDemoBak {

    public static void main(String[] args) {

        List<Integer> ints = getInts();

        Iterator<Integer> iterator = ints.iterator();
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
            if (next % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(ints);

        //If we don't call remove we can use for-each
        ints = getInts();

        for (Integer integer : ints) {
            System.out.println(integer);
            if (integer % 2 == 0) {
//                ints.remove(integer); //Throws ConcurrentModificationException
            }
        }

        //Streams allow for filtering without altering older collection
        System.out.println(ints.stream().filter(i -> i % 2 != 0).collect(Collectors.toList()));


    }

    private static List<Integer> getInts() {
        return IntStream.range(1, 10).boxed().collect(Collectors.toList());
    }
}
