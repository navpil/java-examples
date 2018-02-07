package ua.lviv.navpil.path;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        Path file = Paths.get("xanadu.txt");
        Path copyTo = Paths.get("xanadu2.txt");

        Files.copy(file, copyTo);
        Files.delete(copyTo);


        byte[] bytes = Files.readAllBytes(file);
        String s = new String(bytes);

        System.out.println(s);

        Files.newBufferedReader(file);
                ;
        new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));

    }
}
