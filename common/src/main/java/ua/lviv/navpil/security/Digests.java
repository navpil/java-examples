package ua.lviv.navpil.security;


import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Digests {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new DigestOutputStream(stream, digest)));


        writer.write("Hello");
        writer.write(" ");
        writer.write("world!");

        writer.close();

        System.out.println(new String(Base64.getEncoder().encode(digest.digest())));

//        System.out.println(new String(stream.toByteArray()));

        MessageDigest sha512 = MessageDigest.getInstance("SHA-512");

        sha512.update("Hello world!".getBytes());
        System.out.println(new String(Base64.getEncoder().encode(sha512.digest())));

    }

}
