package ua.lviv.navpil.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class XPathDemo {

    public static void main(String[] args) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {

        ByteArrayInputStream inputStream = new ByteArrayInputStream(("<hello>" +
                "<names>" +
                "<name>world</name><name>monde</name>" +
                "</names></hello>").getBytes());

        XPathFactory xPathFactory = XPathFactory.newInstance();

        XPath xPath = xPathFactory.newXPath();
        XPathExpression name = xPath.compile("/hello/names/name[2]");

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);

        System.out.println(name.evaluate(doc));
        System.out.println(name.evaluate(doc));

//        System.out.println(evaluate);
    }
}
