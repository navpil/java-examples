package ua.lviv.navpil.reflection;

import java.lang.instrument.Instrumentation;

public class InstrumentationDemo {

    private static Instrumentation inst;

    //https://docs.oracle.com/javase/7/docs/api/java/lang/instrument/Instrumentation.html
    //As per documentation:
    // When a JVM is launched in a way that indicates an agent class.
    // In that case an Instrumentation instance is passed to the premain method of the agent class.
    //More about it here:
    //https://docs.oracle.com/javase/7/docs/api/java/lang/instrument/package-summary.html
    public static void premain(String [] args, final Instrumentation inst){
        InstrumentationDemo.inst = inst;
    }

    public static void main(String[] args) {
        System.out.println(InstrumentationDemo.inst.getObjectSize(new Person()));
    }

    public static class Person {
        private String name;
        private int age;
    }
}
