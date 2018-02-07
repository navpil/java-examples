package ua.lviv.navpil.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class StreamOutOfIterable {

    public static void main(String[] args) {
        Iterable<String> names = new ArrayList<String>() {{add("Jim");add("John");}};

        StreamSupport.stream(names.spliterator(), false);

    }

}
