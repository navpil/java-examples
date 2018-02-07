package ua.lviv.navpil.streams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyCharacters {

    public static void main(String[] args) throws IOException {
        Reader in = null;
        Writer out = null;

        try {
            in = new FileReader("xanadu.txt");
            out = new FileWriter("outagain.txt");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
