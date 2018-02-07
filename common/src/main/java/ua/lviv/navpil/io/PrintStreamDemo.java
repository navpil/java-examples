package ua.lviv.navpil.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

public class PrintStreamDemo {

    public static void main(String[] args) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);

        String separator = System.getProperty("line.separator");

        //Platform dependent:
        String expected = String.format("true%nc%n34.3%n");

        printStream.print(true);
        printStream.println();
        printStream.print('c');
        printStream.println();
        printStream.print(34.3);
        printStream.println();
        printStream.close();

        assert expected.equals(new String(out.toByteArray())) : "Strings should be the same";



    }

}
