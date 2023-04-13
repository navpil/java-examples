package ua.lviv.navpil.collections;

import java.util.HashMap;

public class HashMapWontScaleDown {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>(4, 0.75f);

        for (int i = 0; i < 100; i++) {
            map.put("String-" + i, "AnyObject");
        }

        System.out.println(map);

        for (int i = 0; i < 100; i++) {
            map.remove("String-" + i);
        }

        System.out.println(map);



        //ArrayList won't scale down as well, use trimToSize

    }
}
