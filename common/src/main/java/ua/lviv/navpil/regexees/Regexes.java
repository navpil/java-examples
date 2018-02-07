package ua.lviv.navpil.regexees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexes {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("(he(llo)) (world)");
        Matcher matcher = pattern.matcher("Oh hello world! hello world");

        System.out.println(matcher.groupCount());

        while (matcher.find()) {

            System.out.format("I found the text" +
                            " \"%s\" starting at " +
                            "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());

            for (int i = 0; i <= matcher.groupCount(); i++) {
                try {
                    System.out.println("(" + i + ") " + matcher.group(i));
                } catch (Exception e) {
                    System.out.println("Error happened");
                }
            }
        }


    }
}
