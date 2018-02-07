package ua.lviv.navpil.encoding;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadUkrainianText {

    public static void main(String[] args) throws IOException {
        correctReading();
        inCorrectReading();

        BufferedInputStream reader = new BufferedInputStream(new FileInputStream("./ukraine_text.txt"));
        StringBuilder sb = new StringBuilder();

        ArrayList<Byte> byteList = new ArrayList<>();
        int ch;
        while((ch = reader.read()) != -1) {
            byteList.add((byte)ch);
            sb.append((char)ch);
        }

        byte[] bytes = new byte[byteList.size()];
        int i = 0;
        for (Byte aByte : byteList) {
            bytes[i++] = aByte;
        }

        byte[] bytes1 = {-12, -59, -53, -45, -44, 32, -43, -53, -46, -63, -89, -50, -45, -40, -53, -49, -64, 46};

        String line = sb.toString();

        System.out.println(new String(bytes, "KOI8-U"));
        System.out.println(new String(line.getBytes("ISO-8859-1"), "KOI8-U"));
        System.out.println(new String(bytes1, "KOI8-U"));


//        List<String> strings = Arrays.asList("ISO-8859-1", "KOI8-U", "UTF-8");
//        for (String to : strings) {
//            System.out.println("To: " + to + ": " + new String(line.getBytes(), to));
//            for (String from : strings) {
//                System.out.println("From: " + from + "to: " + to +" : "+ new String(line.getBytes(from), to));
//            }
//        }

//        byte[] iso8859 = line.getBytes("ISO-8859-1");
//        byte[] koi8u = line.getBytes("KOI8-U");
//        byte[] utf8=  line.getBytes("UTF-8");
//
//        System.out.println("1: " + line);
//        System.out.println(new String(line.getBytes()));
//
//        System.out.println(new String(line.getBytes(), "KOI8-U"));
//        System.out.println(new String(koi8u));
//        System.out.println(new String(utf8));
//        System.out.println(new String(utf8, "KOI8-U"));

    }

    private static void correctReading() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./ukraine_text.txt"), "KOI8-U"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
    private static void inCorrectReading() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("./ukraine_text.txt")));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(convert(line));
        }
    }

    private static String convert(String line) throws UnsupportedEncodingException {
        return new String(line.getBytes(StandardCharsets.ISO_8859_1), "KOI8-U");
    }
}
