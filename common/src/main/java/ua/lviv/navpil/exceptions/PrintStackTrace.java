package ua.lviv.navpil.exceptions;

import javax.xml.stream.XMLInputFactory;

public class PrintStackTrace {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {


        Class c = Class.forName("com.sun.xml.internal.stream.XMLInputFactoryImpl");
        Object o = c.newInstance();
        XMLInputFactory inputFactory = (XMLInputFactory) o;
//        return inputFactory.createXMLEventReader(stream);



        try {
            doSmth();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void doSmth() {
        throw new NullPointerException();
    }
}
