package ua.lviv.navpil.datetime;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TestTimeParsing {

    public static void main(String[] args) throws DatatypeConfigurationException {
        XMLGregorianCalendar convert = convert2(new Date());

        String xmlFormat = convert.toXMLFormat();
        System.out.println(xmlFormat);
        System.out.println(convert.toString());

        XMLGregorianCalendar result = convert(xmlFormat);

        System.out.println(result.toGregorianCalendar().getTime());


        Instant parse = Instant.parse("2019-04-05T07:52:44.582+02:00");
        System.out.println(parse);


//        java.text.ParseException: Unparseable date: "2019-04-01T09:00:00.000+02:00"    ServiceFault

    }

    private static XMLGregorianCalendar convert(String xmlFormat) throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(xmlFormat);
    }


    private static XMLGregorianCalendar convert(Date start) {
        GregorianCalendar instance = new GregorianCalendar();
        instance.setTime(start);
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(instance);
        } catch (DatatypeConfigurationException e) {
            //This should really never happen
            throw new IllegalStateException(e);
        }

    }

    private static XMLGregorianCalendar convert2(Date start) {
        GregorianCalendar instance = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        instance.setTime(start);
        try {
            DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
            XMLGregorianCalendar c = datatypeFactory.newXMLGregorianCalendar(instance);
            c.setMillisecond(Integer.MIN_VALUE);
            return c;
        } catch (DatatypeConfigurationException e) {
            //This should really never happen
            throw new IllegalStateException(e);
        }
    }
}
