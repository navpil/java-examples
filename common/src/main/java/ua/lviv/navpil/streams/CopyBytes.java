package ua.lviv.navpil.streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyBytes {

    public static void main(String[] args) throws IOException {
        try (InputStream in = new BufferedInputStream(new FileInputStream("xanadu.txt"));
             OutputStream out = new BufferedOutputStream(new FileOutputStream("outagain.txt"))) {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
    }
}
