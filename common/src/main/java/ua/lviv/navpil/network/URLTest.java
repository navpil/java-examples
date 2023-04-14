package ua.lviv.navpil.network;

import java.io.IOException;
import java.net.URL;

public class URLTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://static.pinboard.in/ob/thumbs/ob.030.thumb.png");
        System.out.println("protocol = " + url.getProtocol());
        System.out.println("authority = " + url.getAuthority());
        System.out.println("host = " + url.getHost());
        System.out.println("port = " + url.getPort());
        System.out.println("path = " + url.getPath());
        System.out.println("query = " + url.getQuery());
        System.out.println("filename = " + url.getFile());
        System.out.println("ref = " + url.getRef());

    }


}
