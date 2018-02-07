package ua.lviv.navpil.generics;

import java.util.Comparator;

public class SuperT {

    public static class Holder<T> {

        private final T t;

        public Holder(T t) {
            this.t = t;
        }

//        public <X super T> int compareWith(T asdf, Comparator<X> c){}

    }
}
