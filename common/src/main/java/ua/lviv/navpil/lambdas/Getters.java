package ua.lviv.navpil.lambdas;

import java.io.IOException;

public class Getters {

    public static void main(String[] args) {
        User jim = new User("Jim");
        callGetter(jim::getName);

        String s = throwException();
        System.out.println("Hello");


    }

    private static String throwException() {

        try {
            throw new IOException();
//        } catch (IOException e) {
//            throw e;
//            e.printStackTrace();
        } finally {
            return "";
        }
    }

    private static void callGetter(java.util.function.Supplier<?> getter) {
        System.out.println(getter.get());
    }


    public static class User {

        private final String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}

