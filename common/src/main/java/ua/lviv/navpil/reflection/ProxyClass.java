package ua.lviv.navpil.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class ProxyClass {

    public static void main(String[] args) throws NoSuchMethodException {

        //https://www.javaworld.com/article/2076233/java-se/explore-the-dynamic-proxy-api.html

        Runnable o = (Runnable)Proxy.newProxyInstance(ProxyClass.class.getClassLoader(), new Class[]{Runnable.class}, (new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("toString")) {
                    return "This is my proxied object";
                }
                System.out.println(this);
                System.out.println(proxy);
                if (method.getName().equals("run")) {
                    System.out.println("I'm running!");
                }
                return null;
            }
        }));

        System.out.println(o);

        o.run();
    };


}
