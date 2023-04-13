package ua.lviv.navpil.harmfulgoto;

public class GotoInJava {
    public static void main(String[] args) {

        one:
        {
            System.out.println("One");
            if (true) break one;
            System.out.println("Two");
        }

        ifs:
        if(true){
            System.out.println("One");
            if (true) break ifs;
            System.out.println("Two");
        }

    }
}
