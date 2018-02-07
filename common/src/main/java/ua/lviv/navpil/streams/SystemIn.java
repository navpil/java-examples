package ua.lviv.navpil.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemIn {
    public static void main(String[] args) throws IOException {
        BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(System.in));
        String read = inputStreamReader.readLine();
        System.out.println(read);
    }
}
