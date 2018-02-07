package ua.lviv.navpil.xml;

import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SaxParserExample {

    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        SAXParserFactory documentBuilderFactory = SAXParserFactory.newInstance();
        SAXParser documentBuilder = documentBuilderFactory.newSAXParser();

        documentBuilder.parse(new ByteArrayInputStream(("<hello>" +
                "<names>" +
                "<name>world</name><name>monde</name>" +
                "</names></hello>").getBytes()), new HandlerBase() {
            @Override
            public void startElement(String name, AttributeList attributes) throws SAXException {
                System.out.printf("%nStarted element: %s", name);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.printf(" with value is: %s", new String(ch, start, length));
            }
        });

    }
}
