package ua.lviv.navpil.encoding;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class WriteUkrainianText {

    public static void main(String[] args) throws IOException {
        BufferedWriter isoWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ukrainian_text_iso.properties"), "ISO-8859-1"));
        BufferedWriter koiWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ukrainian_text_koi.properties"), "KOI8-U"));
        BufferedWriter utfWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ukrainian_text_utf8.properties"), "UTF-8"));
        BufferedWriter defaultWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ukrainian_text_default.properties")));

//        writeInto(isoWriter);
        writeInto(koiWriter);
        writeInto(utfWriter);
        writeInto(defaultWriter);

        BufferedWriter w = isoWriter;
        w.write("greetings=");
        w.write(toChars("Здоров був"));
        w.newLine();

        w.close();
    }

    private static char[] toChars(String s) throws UnsupportedEncodingException {
        byte[] bytes = s.getBytes("ISO-8859-1");
        char[] res = new char[bytes.length];
        int i = 0;
        for (byte aByte : bytes) {
            res[i++] = (char)aByte;
        }
        return res;
    }

    private static void writeInto(BufferedWriter w) throws IOException {
        w.write("greetings=");
        w.write("Здоров був");
        w.newLine();

        w.close();
    }

}
