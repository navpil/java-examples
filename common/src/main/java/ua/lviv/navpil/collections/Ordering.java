package ua.lviv.navpil.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ordering {
    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>(Arrays.asList(1 ,2 ,3 ,4, 5, 6, 7, 8));

        ints.stream().forEach(Ordering::show);
        System.out.println();

        ints.stream().sorted(Integer::compare).forEach(Ordering::show);
        System.out.println();

        ints.stream().sorted(((Comparator<Integer>) Integer::compare).reversed()).forEach(Ordering::show);
        System.out.println();

        ints.parallelStream().forEach(Ordering::show);
        System.out.println();

        ints.parallelStream().forEach(Ordering::show);
        System.out.println();

        ints.parallelStream().forEachOrdered(Ordering::show);
        System.out.println();

    }

    private static void show(Object integer) {
        System.out.print(integer + " ");
    }
}
