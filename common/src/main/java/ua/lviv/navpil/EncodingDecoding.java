package ua.lviv.navpil;

import java.util.Arrays;
import java.util.Base64;

public class EncodingDecoding {

    public static void main(String[] args) {

        String token = "EN5YoOWNXDYwBX3LF8QvcIc//rECrfUl4rwzxTSAaWHbcydIUfGf6HQzT/S3TxzzVtonn6OAYX8NujuXUtJ3wg==";
        System.out.println(new String(Base64.getDecoder().decode(token)));

        byte[] encoded = Base64.getDecoder().decode(token);
        System.out.println(Arrays.toString(encoded));
    }
}
