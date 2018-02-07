package ua.lviv.navpil.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class DomParserExample {

    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document parse = documentBuilder.parse(new ByteArrayInputStream(("<hello>" +
                "<names>" +
                "<name>world</name><name>monde</name>" +
                "</names></hello>").getBytes()));

        showNode(parse);

    }

    private static void showNode(Node node) {

        System.out.printf("%sNode, type %d, name %s, value: %s%n", sb.toString(), node.getNodeType(), node.getNodeName(), node.getNodeValue());
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            sb.append(" ");
            showNode(childNodes.item(i));
            sb.delete(sb.length() -1 , sb.length());
        }

    }
}
