package ua.lviv.navpil.collections;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Naive removal by index in ascending order will give OutOfBounds Exception
 */
public class ArrayRemoveInt {

    public static void main(String[] args) {
        List<String> items = IntStream.rangeClosed(1, 100).mapToObj(i -> "item-" + i).collect(Collectors.toList());

        System.out.println(items);

        List<Integer> indexesToRemove = IntStream.rangeClosed(5, 95).boxed().collect(Collectors.toList());
        //Try commenting the Collections.reverse - you will get OOB
        Collections.reverse(indexesToRemove);

        for (Integer index : indexesToRemove) {
            items.remove((int)index);
        }

        System.out.println(items);
    }

}
