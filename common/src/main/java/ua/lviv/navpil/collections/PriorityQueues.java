package ua.lviv.navpil.collections;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueues {
    public static void main(String[] args) {
        Queue<String> pq = new PriorityQueue<>();

        pq.add("One");
        pq.add("Two");
        pq.add("Three");
        pq.add("four");
        pq.add("Five");
        pq.add("ABC");

        StringBuilder fromIterator = new StringBuilder();
        for (String s : pq) {
            fromIterator.append(s);
        }


        StringBuilder fromPoll = new StringBuilder();
        while (!pq.isEmpty()) {
            fromPoll.append(pq.poll());
        }

        if (!fromIterator.toString().equals(fromPoll.toString())) {
            System.out.println(fromIterator + "\n is not equal to \n" + fromPoll);
        }


        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(null, null);
    }
}
