package ua.lviv.navpil.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArraysAsStreams {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList(new String[]{"1"});
        List<Integer> integers = Arrays.asList(new Integer[]{1});

        List<int[]> listOfASingleListArray = Arrays.asList(new int[]{1});//!
        List<Integer> correctList = Arrays.asList(1, 2 ,3);
        List<Integer> ints = Arrays.stream(new int[]{1}).boxed().collect(Collectors.toList());

        System.out.println(
                Objects.equals(
                        Arrays.asList(new Integer[]{1}),
                        Arrays.asList(new int[]{1})
                )
        );


    }
}
