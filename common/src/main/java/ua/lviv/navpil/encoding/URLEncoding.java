package ua.lviv.navpil.encoding;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
//        String enc = "UTF-8";
//        enc = "UTF-8";
//        String encode = URLEncoder.encode("I save my $ в банку . , фвіа /", enc);
//        System.out.println(encode);
//        String decode = URLDecoder.decode(encode, enc);
//        System.out.println(decode);
//
//
        String encode = URLEncoder.encode("AAMkAGE0YjU5YjliLThiMzctNGM3MC1hZjg1LWJhZGYxMzE4ZjUyNgBGAAAAAAAqaRug4GtgTIGplySwdFY2BwBGF0hI8w8gQKdoc6VP/wrUAAAAAAENAABGF0hI8w8gQKdoc6VP/wrUAAB2IZQsAAA=", "UTF-8");
        System.out.println(encode);
        System.out.println(URLDecoder.decode(encode, "UTF-8"));

        System.out.println(URLEncoder.encode("\"", "UTF-8"));
    }
}
