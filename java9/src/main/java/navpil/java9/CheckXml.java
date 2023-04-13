package navpil.java9;

import javax.xml.stream.XMLInputFactory;

public class CheckXml {

    public static void main(String[] args) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        System.out.println(xmlInputFactory.getClass());
        System.out.println(xmlInputFactory.getClass().getClassLoader());
    }
}
