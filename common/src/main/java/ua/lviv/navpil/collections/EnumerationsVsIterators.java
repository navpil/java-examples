package ua.lviv.navpil.collections;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class EnumerationsVsIterators {

    public static void main(String[] args) {

        Vector<String> strings = new Vector<>();
        for (int i = 0; i < 10; i++) {
            strings.add("s" + i);
        }


        Iterator<String> iterator = strings.iterator();


        Enumeration<String> enumeration = strings.elements();
        strings.add("Another");

        for(;enumeration.hasMoreElements();) {
            String s = enumeration.nextElement();
            strings.remove("Another");
            System.out.println(s);
        }


        for(;iterator.hasNext();) {
            String s = iterator.next();
        }



    }
}
