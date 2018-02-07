package ua.lviv.navpil.path;

import java.nio.file.Paths;

public class PathDemo {

    public static void main(String[] args) {
        String winPath = "%PROGRAM_DATA%\\src\\main\\properties.txt";
        String normalPath = "./src/main/properties.txt";
        String just = "properties.txt";

        System.out.println(Paths.get(winPath).getParent().toString());
        System.out.println(Paths.get(normalPath).getParent().toString());
        System.out.println(Paths.get(normalPath).getNameCount());
//        System.out.println(Paths.get(just).getParent().toString());

        System.out.println(Paths.get(just).getNameCount());




    }
}
