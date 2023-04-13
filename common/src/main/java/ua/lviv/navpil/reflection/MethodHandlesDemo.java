package ua.lviv.navpil.reflection;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MethodHandlesDemo {

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle constructor = lookup.findConstructor(MethodHandlesDemo.class, MethodType.methodType(void.class));
        MethodHandlesDemo invoke = (MethodHandlesDemo)constructor.invoke();
        System.out.println(invoke.sayHello());
        MethodType sToIMethodType = MethodType.methodType(int.class, String.class);
        MethodHandle count = lookup.findStatic(Counter.class, "count", sToIMethodType);
        long hi = (int)count.invokeExact("hi");

        MethodHandle instanceCount = lookup.findVirtual(Counter.class, "instanceCount", MethodType.methodType(int.class));
        System.out.println(instanceCount.invoke(new Counter()));

        Constructor<MethodHandlesDemo> c = MethodHandlesDemo.class.getConstructor();
        MethodHandlesDemo methodHandlesDemo = c.newInstance();
        System.out.println(methodHandlesDemo.sayHello());
        Method method = Counter.class.getMethod("count", String.class);
        System.out.println(method.invoke(Counter.class,"hi"));


        Method dabl = Counter.class.getMethod("dabl", int.class);
        System.out.println(dabl.invoke(Counter.class, 2));


    }

    public String sayHello() {
        return "Hello";
    }
}

class Counter {

//    static int count(String name) {
//        return name.length();
//    }

    public static int count(String name) {
        return name.length();
    }

    public static int dabl(int a) {
        return a * 2;
    }

    int instanceCount() {
        return 42;
    }

}
