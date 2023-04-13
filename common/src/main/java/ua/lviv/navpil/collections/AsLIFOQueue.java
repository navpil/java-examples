package ua.lviv.navpil.collections;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class AsLIFOQueue {

    public static void main(String[] args) {

        Deque<String> strings = new ArrayDeque<>();
        strings = new LinkedList<>();

//        strings.addFirst("one");
//        strings.addFirst("two");
//        strings.addFirst("three");


        Queue<String> strings1 = strings;

//        strings1 = Collections.asLifoQueue(strings);

        addRemove(strings1);

        addRemove(new LinkedList<>());



    }

    private static void addRemove(Queue<String> strings1) {
        for (int i = 0; i < 3; i++) {
            String item = "item-" + i;
            strings1.add(item);
            System.out.println("added " + item);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("removed " + strings1.remove());
        }
    }
}
