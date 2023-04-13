package ua.lviv.navpil;

import java.util.HashMap;

public class TestClass {

    private static final HashMap<String, TestObject> sequence = new HashMap<String, TestObject>() {
        {
            put("Name", new TestObject());
        }
    };

    public static void main(String[] args) {

        TestClass t = new TestClass();
    }

    private static class TestObject{

        private final String name;

        TestObject(){
            name = sequence.get("Name").getName();
        }

        String getName() {
            return name;
        }
    }
}