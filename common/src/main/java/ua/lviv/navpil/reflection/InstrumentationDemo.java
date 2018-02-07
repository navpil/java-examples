package ua.lviv.navpil.reflection;

import ua.lviv.navpil.javafx.Person;

import java.lang.instrument.Instrumentation;

public class InstrumentationDemo {

    private static Instrumentation inst;

    public static void premain(String [] args, final Instrumentation inst){
        InstrumentationDemo.inst = inst;
    }

    public static void main(String[] args) {
        System.out.println(InstrumentationDemo.inst.getObjectSize(new Person()));
    }
}
