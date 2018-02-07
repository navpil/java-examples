package ua.lviv.navpil.streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreams {
    public static void main(String[] args) throws IOException {
        String dataFile = "datafile.txt";

        DataOutputStream stream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));

        stream.writeDouble(4.5);
        stream.writeInt(2);
        stream.writeUTF("T-Shirt");

        stream.close();


        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));

        try {
            while(true) {
                double price = in.readDouble();
                int count = in.readInt();
                String name = in.readUTF();

                System.out.format("There is %d units of %s at $%.2f%n", count, name, price);
            }
        } catch (EOFException e) {

        }

        in.close();
    }
}
