package ua.lviv.navpil.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GroupBy {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("oslo", "oosl", "london", "nodlon", "beijing", "sloo");

        Collection<List<String>> listOfAnagrams = list.stream().collect(Collectors.groupingBy(GroupBy::sorted)).values();

        System.out.println(listOfAnagrams);
    }

    public static String sorted(String s) {
        char[] bytes = s.toCharArray();
        Arrays.sort(bytes);
        return new String(bytes);
    }
}
