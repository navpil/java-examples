package ua.lviv.navpil.spi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

public class ManualSPI {

    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = ManualSPI.class.getClassLoader();
        List<String> services = List.of("com.fasterxml.jackson.core.JsonFactory", "java.sql.Driver");
        for (String service : services) {
            System.out.println("Searching for " + service + " implementations");
            Enumeration<URL> resources = classLoader.getResources("META-INF/services/" + service);
            while (resources.hasMoreElements()) {
                URL resourceWithSpi = resources.nextElement();
                try (InputStream inputStream = resourceWithSpi.openStream();
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))
                ) {
                    String line;
                    System.out.println("Element found in " + resourceWithSpi);
                    while((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }
                }
            }
        }
    }
}
