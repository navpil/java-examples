package ua.lviv.navpil.collections;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.stream.Collectors;

public class TestCollections {



    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }

        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            people.add(new Person("Name" + i, i));
        }

        Map<String, Integer> map = people.stream().collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println(map);

        Collections.fill(list.subList(3, 9), "6");

        System.out.println(list.stream().collect(Collectors.toMap(val -> val, val -> val, (v1, v2) -> v1 + v2)));

        System.out.println(list);

//        ListIterator<String> it = list.listIterator(list.size());
//
//        while (it.hasPrevious()) {
//            System.out.println(it.previous());
//        }
//
//        int a = 1;
//        int b = -a;
//
//        int i = -Integer.MIN_VALUE;
//        int minValue = Integer.MIN_VALUE;
//        System.out.println(i ==  minValue);
//
//        System.out.println(0b10000000_00000000_00000000_00000000);
//        System.out.println(0b11111111_11111111_11111111_11111111);

    }
}
