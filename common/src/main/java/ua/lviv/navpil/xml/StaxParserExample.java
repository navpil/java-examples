package ua.lviv.navpil.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class StaxParserExample {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException {

        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new ByteArrayInputStream(("<hello>" +
                "<names>" +
                "<name>world</name><name>monde</name>" +
                "</names></hello>").getBytes()));
        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            switch (xmlEvent.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    System.out.printf("%nStarted element: %s", xmlEvent.asStartElement().getName());
                    break;
                case XMLStreamConstants.CHARACTERS:
                    Characters characters = xmlEvent.asCharacters();
                    System.out.printf(" with value is: %s", characters.getData());
                    break;

            }
        }

    }
}
