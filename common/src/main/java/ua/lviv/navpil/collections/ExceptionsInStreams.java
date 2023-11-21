package ua.lviv.navpil.collections;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Streams do not accept lambdas which throw checked exceptions.
Need to workaround it some way
 */
public class ExceptionsInStreams {

    public static void main(String[] args) throws IOException {
        List<String> strings = Arrays.asList("one", "two");

        FileFilter fileFilter = new FileFilter();
        List<String> collect = strings.stream().filter(fileFilter::fileExists).collect(Collectors.toList());

        System.out.println(fileFilter.throwed);

        System.out.println(collect);
    }

    public static Boolean fileExists(String name) throws IOException {
        if ("one".equals(name)) {
            throw new IOException();
        }
        return true;
    }

    public static class FileFilter {
        List<IOException> throwed = new ArrayList<>();

        public Boolean fileExists(String name) {
            try {
                return ExceptionsInStreams.fileExists(name);
            } catch (IOException e) {
                throwed.add(e);
                return false;
            }
        }
    }
}
