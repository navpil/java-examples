package ua.lviv.navpil;

public class NoClassDefFoundReproduce {

    public static void main(String[] args) {
        System.out.println("OK2");
        try {
            System.out.println(ClassB.getInstance());
        } catch (Throwable e) {
            System.out.println(e);
        }
        System.out.println(ClassB.getInstance());
    }


    public static class ClassB {
        public static final String a = ((String)null).toString();

        public static ClassB getInstance() {
            return new ClassB();
        }
    }
    }
