package ua.lviv.navpil.streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Scanners {

    public static void main(String[] args) throws FileNotFoundException {
//        try(Scanner s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")))) {
//            while (s.hasNext()) {
//                System.out.println(s.next());
//            }
//        }

        try(Scanner s = new Scanner(new BufferedReader(new FileReader("doubles.txt")))) {
            s.useLocale(Locale.US);
            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    System.out.println(s.nextDouble());
                } else if (s.hasNextLine()) {
                    String line = s.nextLine();
                    if (!line.isEmpty())
                        System.out.println(line);
                } else {
                    System.out.println("This is interesting: " + s.next());
                }
            }
        }
    }

}
