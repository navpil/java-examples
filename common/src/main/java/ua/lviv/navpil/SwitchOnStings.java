package ua.lviv.navpil;

public class SwitchOnStings {

    /*
     * Try to compile the class and see how switch on string looks like in the decompiled class. It's ugly.
     */
    public static void main(String[] args) {
        String name = "hello";
        switch (name) {
            case "hello":
                System.out.println("One");
                break;
            case "world":
                System.out.println("Two");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
