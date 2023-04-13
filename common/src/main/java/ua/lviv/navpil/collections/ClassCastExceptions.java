package ua.lviv.navpil.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ClassCastExceptions {

    public static void main(String[] args) {

        try {
            check(new TreeSet<>());
        } catch (Exception e) {
            System.out.println("TreeSet throws " + e.getClass().getName());
        }

        check(new HashSet<>());
        System.out.println("HashSet returns false ");

    }

    private static void check(Set<String> strings) {
        strings.add("One");
        strings.add("Two");
        //Class cat exception thrown runtime
        System.out.println(strings.contains(2));
    }
}
