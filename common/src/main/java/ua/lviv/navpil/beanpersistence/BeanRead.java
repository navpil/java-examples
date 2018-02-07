package ua.lviv.navpil.beanpersistence;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BeanRead {
    public static void main(String[] args) throws FileNotFoundException {
        XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("./Beanarchive.xml")));
        Object o = xmlDecoder.readObject();
        System.out.println(o);

    }
}
