package ua.lviv.navpil.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class OutputStreamDemo {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        properties.setProperty("one", "two");
        properties.setProperty("three", "four");


        try(OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("D:/projects/testapps/java-tutorial/textfile.txt"))) {
            outputStreamWriter.write("hahaha");
        }

    }
}
